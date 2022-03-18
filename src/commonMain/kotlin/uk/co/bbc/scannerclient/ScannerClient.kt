package uk.co.bbc.scannerclient

import io.ktor.client.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uk.co.bbc.scannerclient.expected.DefaultDispatcher
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.services.ScannerService

interface ScannerClient {
    fun getContent(type: ContentType, callback: (List<Content>) -> Unit)
    fun close()

    enum class ContentType {
        iPlayer, Sounds, News, NewsVertical, Video
    }

    companion object {
        val singleton = KtorScannerClient()
    }
}

class KtorScannerClient(
    private val httpClient: HttpClient = DI.httpClient,
    private val contentServices: Map<ScannerClient.ContentType, ScannerService> = DI.contentServices
) : ScannerClient {

    private val clientScope = CoroutineScope(DefaultDispatcher)

    override fun getContent(type: ScannerClient.ContentType, callback: (List<Content>) -> Unit) {
        clientScope.launch {
            contentServices[type]
                ?.getContent()
                ?.let(callback)
        }
    }

    override fun close() {
        clientScope.cancel()

        httpClient.close()
    }
}
