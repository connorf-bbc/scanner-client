import kotlinx.coroutines.runBlocking
import uk.co.bbc.scannerclient.ScannerClient
import uk.co.bbc.scannerclient.model.Content
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

public fun main() {
    val client = ScannerClient.singleton

    val result: List<Content> = ScannerClient.ContentType.values()
        .flatMap { type ->
            client::getContent.fromCallbackToBlocking(type)
        }

    println(result)
}

private typealias Callback<T> = (T) -> Unit

private fun <P, T> ((P, Callback<T>) -> Unit).fromCallbackToBlocking(p: P): T =
    runBlocking { suspendCoroutine { c -> this@fromCallbackToBlocking(p) { c.resume(it) } } }