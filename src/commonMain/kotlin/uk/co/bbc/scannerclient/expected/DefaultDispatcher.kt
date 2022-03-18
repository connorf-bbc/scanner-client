package uk.co.bbc.scannerclient.expected

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
internal expect val DefaultDispatcher: CoroutineDispatcher