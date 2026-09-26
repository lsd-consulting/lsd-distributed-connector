package io.lsdconsulting.lsd.distributed.connector.repository.async

import io.lsdconsulting.lsd.distributed.connector.model.InterceptedFlow
import kotlinx.coroutines.flow.Flow

interface InterceptedDocumentAdminAsynchronousRepository {
    suspend fun findRecentFlows(resultSizeLimit: Int): List<InterceptedFlow>
    fun findRecentFlows(): Flow<InterceptedFlow>
}