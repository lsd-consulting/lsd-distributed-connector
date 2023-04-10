package io.lsdconsulting.lsd.distributed.access.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Map;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class InterceptedInteraction {
    String traceId;
    String body;
    Map<String, Collection<String>> requestHeaders;
    Map<String, Collection<String>> responseHeaders;
    String serviceName; // the calling service or the publisher or consumer
    String target; // the called service or the exchange name
    String path; // the called URL or the exchange name
    String httpStatus;
    String httpMethod;
    InteractionType interactionType;
    String profile;
    Long elapsedTime;
    ZonedDateTime createdAt;
}
