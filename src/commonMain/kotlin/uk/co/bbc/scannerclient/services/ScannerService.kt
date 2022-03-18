package uk.co.bbc.scannerclient.services

import uk.co.bbc.scannerclient.model.Content

internal interface ScannerService {
    @Throws(Throwable::class)
    suspend fun getContent(): List<Content>
}

