package io.lsdconsulting.lsd.distributed.connector.repository.async

import io.lsdconsulting.lsd.distributed.connector.model.InterceptedInteraction
import io.lsdconsulting.lsd.distributed.connector.repository.BaseInterceptedDocumentRepository
import kotlinx.coroutines.flow.Flow

interface InterceptedDocumentAsynchronousRepository : BaseInterceptedDocumentRepository {
    suspend fun save(interceptedInteraction: InterceptedInteraction)
    fun findByTraceIds(vararg traceId: String): Flow<InterceptedInteraction>
}
