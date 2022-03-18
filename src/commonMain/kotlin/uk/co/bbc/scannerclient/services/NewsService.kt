package uk.co.bbc.scannerclient.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.model.response.TrevorResponse
import uk.co.bbc.scannerclient.services.NewsService.Orientation.HORIZONTAL
import uk.co.bbc.scannerclient.services.NewsService.Orientation.VERTICAL

class NewsService(
    private val httpClient: HttpClient,
    orientation: Orientation
) : ScannerService {
    enum class Orientation {
        VERTICAL, HORIZONTAL
    }

    private val url = when (orientation) {
        VERTICAL -> Url("https://trevor-producer-cdn.api.bbci.co.uk/content/cps/news/video_and_audio/ten_to_watch")
        HORIZONTAL -> Url("https://trevor-producer.api.bbci.co.uk/content/most_popular/news")
    }

    override suspend fun getContent(): List<Content> =
        httpClient.get<TrevorResponse>(url)
            .let(Content.NewsContent.Companion::fromDto)
}