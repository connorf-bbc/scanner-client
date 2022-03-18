package uk.co.bbc.scannerclient

import io.ktor.client.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uk.co.bbc.scannerclient.expected.DefaultDispatcher
import uk.co.bbc.scannerclient.model.Content
import uk.co.bbc.scannerclient.services.ScannerService

public interface ScannerClient {
    public fun getContent(type: ContentType, callback: (List<Content>) -> Unit)
    public fun close()

    public enum class ContentType {
        iPlayer, Sounds, News, NewsVertical, Video
    }

    public companion object {
        public val singleton: ScannerClient = KtorScannerClient()
    }
}

internal class KtorScannerClient(
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
