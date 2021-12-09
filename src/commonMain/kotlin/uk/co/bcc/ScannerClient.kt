package uk.co.bcc

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

interface ScannerClient {
    fun todos(callback: (String) -> Unit)
    fun close()
}

object KtorScannerClient: ScannerClient {
    private val httpClient = HttpClient()

    private val address = Url("https://jsonplaceholder.typicode.com/todos/")

    private val clientScope = CoroutineScope(Dispatchers.Default)

    override fun todos(callback: (String) -> Unit) {
        clientScope.launch {
            val response = httpClient.get<HttpResponse>(address)
            val body = response.receive<ByteArray>().decodeToString()

            callback(body)
        }
    }

    override fun close() {
        clientScope.cancel()

        httpClient.close()
    }
}
