package io.lsdconsulting.lsd.distributed.access.repository

import io.lsdconsulting.lsd.distributed.access.model.InterceptedInteraction

interface InterceptedDocumentRepository {
    fun save(interceptedInteraction: InterceptedInteraction)
    fun findByTraceIds(vararg traceId: String): List<InterceptedInteraction>
    fun isActive(): Boolean
}
