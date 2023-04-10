package io.lsdconsulting.lsd.distributed.access.model

data class InterceptedFlow(
    var initialInteraction: InterceptedInteraction,
    var finalInteraction: InterceptedInteraction,
    var totalCapturedInteractions: Int,
)