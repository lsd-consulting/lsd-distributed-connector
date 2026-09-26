package io.lsdconsulting.lsd.distributed.connector.repository

import io.lsdconsulting.lsd.distributed.connector.model.InterceptedInteraction

interface InterceptedDocumentRepository : BaseInterceptedDocumentRepository {
    fun save(interceptedInteraction: InterceptedInteraction)
    fun findByTraceIds(vararg traceId: String): List<InterceptedInteraction>
}
