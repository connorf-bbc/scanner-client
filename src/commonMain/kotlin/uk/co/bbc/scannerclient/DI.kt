package uk.co.bbc.scannerclient

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import uk.co.bbc.scannerclient.ScannerClient.ContentType
import uk.co.bbc.scannerclient.services.LiveService
import uk.co.bbc.scannerclient.services.NewsService
import uk.co.bbc.scannerclient.services.NewsService.Orientation.HORIZONTAL
import uk.co.bbc.scannerclient.services.NewsService.Orientation.VERTICAL
import uk.co.bbc.scannerclient.services.SoundsService
import uk.co.bbc.scannerclient.services.iPlayerService

object DI {
    val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            })
        }
    }

    val contentServices = mapOf(
        ContentType.iPlayer to iPlayerService(httpClient),
        ContentType.Sounds to SoundsService(httpClient),
        ContentType.News to NewsService(httpClient, HORIZONTAL),
        ContentType.NewsVertical to NewsService(httpClient, VERTICAL),
        ContentType.Video to LiveService(httpClient)
    )
}
