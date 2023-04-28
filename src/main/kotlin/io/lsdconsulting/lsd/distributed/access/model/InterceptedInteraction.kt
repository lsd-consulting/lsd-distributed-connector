package io.lsdconsulting.lsd.distributed.access.model

import java.time.ZonedDateTime

data class InterceptedInteraction(
    val traceId: String,
    val body: String? = null,
    val requestHeaders: MutableMap<String, Collection<String>> = mutableMapOf(),
    val responseHeaders: Map<String, Collection<String>> = mutableMapOf(),
    val serviceName: String, // the calling service or the publisher or consumer
    val target: String, // the called service or the exchange/topic name
    val path: String, // the called URL or the exchange/topic name
    val httpStatus: String? = null,
    val httpMethod: String? = null,
    val interactionType: InteractionType,
    val profile: String? = null,
    val elapsedTime: Long,
    val createdAt: ZonedDateTime,
)
