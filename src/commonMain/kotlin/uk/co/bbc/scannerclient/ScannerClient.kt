package uk.co.bbc.scannerclient

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uk.co.bbc.scannerclient.expected.DefaultDispatcher
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.services.LiveService
import uk.co.bbc.scannerclient.services.NewsService
import uk.co.bbc.scannerclient.services.SoundsService
import uk.co.bbc.scannerclient.services.iPlayerService
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

    private val clientScope = CoroutineScope(DefaultDispatcher)

    private val contentServices = listOf(
        iPlayerService(httpClient),
        SoundsService(httpClient),
        NewsService(httpClient),
        LiveService(httpClient)
    )

    override fun getContent(callback: (List<Content>) -> Unit) {
        clientScope.launch {
            val content = contentServices.flatMap {
                it.getContent()
            }

            callback(content)
        }
    }

    override fun close() {
        clientScope.cancel()

        httpClient.close()
    }
}
