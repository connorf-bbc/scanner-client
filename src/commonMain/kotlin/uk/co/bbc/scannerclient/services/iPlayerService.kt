package uk.co.bbc.scannerclient.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.model.response.IblResponse

internal class iPlayerService(private val httpClient: HttpClient) : ScannerService {
    private val url =
        Url("https://ibl.api.bbci.co.uk/ibl/v1/groups/popular/episodes?type=plays")

    override suspend fun getContent(): List<Content> =
        httpClient.get<IblResponse>(url)
            .let(Content.iPlayerContent.Companion::fromDto)
}