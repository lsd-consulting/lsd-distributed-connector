package io.lsdconsulting.lsd.distributed.connector.repository

interface BaseInterceptedDocumentRepository {
    fun isActive(): Boolean
}