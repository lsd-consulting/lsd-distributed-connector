package io.lsdconsulting.lsd.distributed.access.repository

import io.lsdconsulting.lsd.distributed.access.model.InterceptedFlow

private const val DEFAULT_RESULT_SIZE = 10

interface InterceptedDocumentAdminRepository {
    fun findRecentFlows(resultSize: Int = DEFAULT_RESULT_SIZE): List<InterceptedFlow>
}