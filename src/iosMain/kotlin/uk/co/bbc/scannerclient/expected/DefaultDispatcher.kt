package uk.co.bbc.scannerclient.expected

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val DefaultDispatcher: CoroutineDispatcher = NSQueueDispatcher(dispatch_get_main_queue())

internal class NSQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
): CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}