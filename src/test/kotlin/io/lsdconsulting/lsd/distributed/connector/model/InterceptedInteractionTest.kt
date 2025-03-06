package io.lsdconsulting.lsd.distributed.connector.model

import io.github.krandom.KRandom
import io.kotest.matchers.shouldBe
import io.lsdconsulting.lsd.distributed.connector.model.InteractionType.CONSUME
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

@OptIn(ExperimentalSerializationApi::class)
class InterceptedInteractionTest {
    private val kRandom = KRandom()

    @Test
    fun `should instantiate intercepted interaction with minimum values`() {
        val createdAt = ZonedDateTime.now()
        val interceptedInteraction = InterceptedInteraction(
            traceId = "traceId",
            serviceName = "serviceName",
            target = "target",
            path = "path",
            interactionType = CONSUME,
            elapsedTime = 1,
            createdAt = createdAt
        )

        interceptedInteraction shouldBe InterceptedInteraction(
            traceId = "traceId",
            serviceName = "serviceName",
            target = "target",
            path = "path",
            interactionType = CONSUME,
            elapsedTime = 1,
            createdAt = createdAt,
            body = null,
            requestHeaders = mapOf(),
            responseHeaders = mapOf(),
            httpStatus = null,
            httpMethod = null,
            profile = null
        )
    }

    @Test
    fun `should serialize and deserialize correctly`() {
        val expectedInterceptedInteraction: InterceptedInteraction =
            kRandom.nextObject(InterceptedInteraction::class.java)

        val encodedBytes = ProtoBuf.encodeToByteArray(expectedInterceptedInteraction)
        val actualInterceptedInteraction = ProtoBuf.decodeFromByteArray<InterceptedInteraction>(encodedBytes)

        actualInterceptedInteraction shouldBe expectedInterceptedInteraction
    }
}
