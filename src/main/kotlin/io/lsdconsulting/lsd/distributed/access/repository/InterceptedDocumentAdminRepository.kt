package io.lsdconsulting.lsd.distributed.access.repository

import io.lsdconsulting.lsd.distributed.access.model.InterceptedFlow

interface InterceptedDocumentAdminRepository {
    fun findRecentFlows(number: Int): List<InterceptedFlow>
}