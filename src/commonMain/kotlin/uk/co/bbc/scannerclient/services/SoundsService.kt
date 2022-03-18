package uk.co.bbc.scannerclient.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.model.response.RmsResponse

internal class SoundsService(private val httpClient: HttpClient) : ScannerService {
    private val url =
        Url("https://rms.api.bbc.co.uk/v2/programmes/playable?category=music-rockandindie&sort=-available_from_date")

    override suspend fun getContent(): List<Content> =
        httpClient.get<RmsResponse>(url)
            .let(Content.SoundsContent.Companion::fromDto)
}