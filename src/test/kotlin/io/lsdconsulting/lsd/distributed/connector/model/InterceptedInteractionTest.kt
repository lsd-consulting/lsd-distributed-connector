package io.lsdconsulting.lsd.distributed.connector.model

import io.lsdconsulting.lsd.distributed.connector.model.InteractionType.CONSUME
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime

class InterceptedInteractionTest {

    @Test
    fun shouldInstantiateInterceptedInteractionWithMinimumValues() {
        InterceptedInteraction(
            traceId = "traceId",
            serviceName = "serviceName",
            target = "target",
            path = "path",
            interactionType = CONSUME,
            elapsedTime = 1,
            createdAt = ZonedDateTime.now()
        )
    }
}
