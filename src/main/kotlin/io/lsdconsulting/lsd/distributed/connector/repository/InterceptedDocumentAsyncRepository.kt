package io.lsdconsulting.lsd.distributed.connector.repository

import io.lsdconsulting.lsd.distributed.connector.model.InterceptedInteraction
import kotlinx.coroutines.flow.Flow

interface InterceptedDocumentAsyncRepository : BaseInterceptedDocumentRepository {
    suspend fun save(interceptedInteraction: InterceptedInteraction)
    fun findByTraceIds(vararg traceId: String): Flow<InterceptedInteraction>
}