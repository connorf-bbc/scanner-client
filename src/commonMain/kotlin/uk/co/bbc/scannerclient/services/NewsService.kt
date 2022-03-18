package uk.co.bbc.scannerclient.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.model.response.TrevorResponse

class NewsService(private val httpClient: HttpClient) : ScannerService {
    private val url =
        Url("https://trevor-producer.api.bbci.co.uk/content/most_popular/news")

    private val verticalUrl =
        Url("https://trevor-producer-cdn.api.bbci.co.uk/content/cps/news/video_and_audio/ten_to_watch")

    override suspend fun getContent(): List<Content> =
        httpClient.get<TrevorResponse>(url)
            .let(Content.NewsContent.Companion::fromDto) +
                httpClient.get<TrevorResponse>(verticalUrl)
                    .let(Content.NewsContent.Companion::fromDto)
}