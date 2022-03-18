package uk.co.bbc.scannerclient.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.model.response.NitroResponse

internal class LiveService(private val httpClient: HttpClient) : ScannerService {
    private val url =
        Url("https://programmes.api.bbc.com/nitro/api/programmes?api_key=L9oibgX6CJpFCltEkDHcXWxxHXE2cLCI&availability=available&availability_type=webcast&mixin=available_webcasts&page_size=50")

    override suspend fun getContent(): List<Content> =
        httpClient.get<NitroResponse>(url)
            .let(Content.LiveContent.Companion::fromDto)
}
