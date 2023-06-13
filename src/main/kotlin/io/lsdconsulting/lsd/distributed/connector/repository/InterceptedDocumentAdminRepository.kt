package io.lsdconsulting.lsd.distributed.connector.repository

import io.lsdconsulting.lsd.distributed.connector.model.InterceptedFlow

private const val DEFAULT_RESULT_SIZE_LIMIT = 10

interface InterceptedDocumentAdminRepository {
    fun findRecentFlows(resultSizeLimit: Int = DEFAULT_RESULT_SIZE_LIMIT): List<InterceptedFlow>
}