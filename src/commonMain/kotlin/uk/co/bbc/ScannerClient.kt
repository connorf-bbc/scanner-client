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
import kotlinx.serialization.json.Json as KotlinxJson

interface ScannerClient {
    fun getContent(callback: (List<Content>) -> Unit)
    fun close()
}

object KtorScannerClient : ScannerClient {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(KotlinxJson {
                ignoreUnknownKeys = true
            })
        }
    }

    private val clientScope = CoroutineScope(Dispatchers.Default)

    private val iPlayerUrl = Url("https://ibl.api.bbci.co.uk/ibl/v1/groups/popular/episodes?type=plays")

    override fun getContent(callback: (List<Content>) -> Unit) {
        clientScope.launch {
            val content =
                httpClient
                    .get<IblResponse>(iPlayerUrl)
                    .groupEpisodes.elements
                    .map(Content.iPlayerContent::fromDto)

            callback(content)
        }
    }

    override fun close() {
        clientScope.cancel()

        httpClient.close()
    }
}
