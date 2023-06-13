package io.lsdconsulting.lsd.distributed.connector.model

data class InterceptedFlow(
    var initialInteraction: InterceptedInteraction,
    var finalInteraction: InterceptedInteraction,
    var totalCapturedInteractions: Int,
)