package io.lsdconsulting.lsd.distributed.connector.model

import io.lsdconsulting.lsd.distributed.connector.serialization.ZonedDateTimeSerializer
import kotlinx.serialization.Serializable
import java.time.ZonedDateTime

@Serializable
data class InterceptedInteraction(
    val traceId: String,
    val body: String? = null,
    val requestHeaders: Map<String, Collection<String>> = mapOf(),
    val responseHeaders: Map<String, Collection<String>> = mapOf(),
    val serviceName: String, // the calling service or the publisher or consumer
    val target: String, // the called service or the exchange/topic name
    val path: String, // the called URL or the exchange/topic name
    val httpStatus: String? = null,
    val httpMethod: String? = null,
    val interactionType: InteractionType,
    val profile: String? = null,
    val elapsedTime: Long,
    @Serializable(ZonedDateTimeSerializer::class)
    val createdAt: ZonedDateTime,
)
