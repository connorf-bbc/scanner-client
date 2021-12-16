package uk.co.bbc

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
internal expect val DefaultDispatcher: CoroutineDispatcher