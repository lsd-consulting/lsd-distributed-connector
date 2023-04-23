package io.lsdconsulting.lsd.distributed.access.repository

import io.lsdconsulting.lsd.distributed.access.model.InterceptedFlow

private const val DEFAULT_RESULT_SIZE_LIMIT = 10

interface InterceptedDocumentAdminRepository {
    fun findRecentFlows(resultSizeLimit: Int = DEFAULT_RESULT_SIZE_LIMIT): List<InterceptedFlow>
}