package uk.co.bbc

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uk.co.bbc.model.Content
import uk.co.bbc.model.response.IblResponse
import uk.co.bbc.model.response.NitroResponse
import uk.co.bbc.model.response.RmsResponse
import uk.co.bbc.model.response.TrevorResponse
import kotlinx.serialization.json.Json as KotlinxJson

interface ScannerClient {
    fun getContent(callback: (List<Content>) -> Unit)
    fun close()
}

class KtorScannerClient : ScannerClient {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(KotlinxJson {
                ignoreUnknownKeys = true
            })
        }
    }

    private val clientScope = CoroutineScope(Dispatchers.Default)

    override fun getContent(callback: (List<Content>) -> Unit) {
        clientScope.launch {
            val iPlayerContent =
                getiPlayerContent()
                    .let(Content.iPlayerContent::fromDto)

            val soundsContent =
                getSoundsContent()
                    .let(Content.SoundsContent::fromDto)

            val newsContent =
                getNewsContent(vertical = false)
                    .let(Content.NewsContent::fromDto)

            val verticalNewsContent =
                getNewsContent(vertical = true)
                    .let(Content.NewsContent::fromDto)

            val liveContent =
                getLiveContent()
                    .let(Content.LiveContent::fromDto)

            val content = liveContent + verticalNewsContent + newsContent + soundsContent + iPlayerContent

            callback(content)
        }
    }

    @Throws(Throwable::class)
    private suspend fun getiPlayerContent(): IblResponse =
        httpClient.get(iPlayerUrl)

    @Throws(Throwable::class)
    private suspend fun getSoundsContent(): RmsResponse =
        httpClient.get(soundsUrl)

    @Throws(Throwable::class)
    private suspend fun getNewsContent(vertical: Boolean): TrevorResponse =
        httpClient.get(
            if (vertical) newsVerticalUrl else newsUrl
        )

    @Throws(Throwable::class)
    private suspend fun getLiveContent(): NitroResponse =
        httpClient.get(liveUrl)

    override fun close() {
        clientScope.cancel()

        httpClient.close()
    }

    companion object {
        private val iPlayerUrl = Url("https://ibl.api.bbci.co.uk/ibl/v1/groups/popular/episodes?type=plays")

        private val soundsUrl = Url("https://rms.api.bbc.co.uk/v2/programmes/playable?category=music-rockandindie&sort=-available_from_date")

        private val newsUrl = Url("https://trevor-producer.api.bbci.co.uk/content/most_popular/news")

        private val newsVerticalUrl = Url("https://trevor-producer-cdn.api.bbci.co.uk/content/cps/news/video_and_audio/ten_to_watch")

        private val liveUrl = Url("https://programmes.api.bbc.com/nitro/api/programmes?api_key=L9oibgX6CJpFCltEkDHcXWxxHXE2cLCI&availability=available&availability_type=webcast&mixin=available_webcasts&page_size=50")
    }
}
