package io.lsdconsulting.lsd.distributed.access.model;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class InterceptedInteractionFactoryShould {

    private final String profile = randomAlphanumeric(10);
    private final String body = randomAlphanumeric(30);
    private final String traceId = randomAlphanumeric(30);
    private final Map<String, Collection<String>> requestHeaders = Map.of(randomAlphanumeric(10), List.of(randomAlphanumeric(10)));
    private final Map<String, Collection<String>> responseHeaders = Map.of(randomAlphanumeric(10), List.of(randomAlphanumeric(10)));
    private final String serviceName = randomAlphanumeric(30);
    private final String target = randomAlphanumeric(30);
    private final String path = randomAlphanumeric(30);
    private final String httpStatus = randomAlphanumeric(30);
    private final String httpMethod = randomAlphanumeric(30);
    private final Long elapsedTime = nextLong();
    private final Type type = Type.values()[RandomUtils.nextInt(0,Type.values().length)];

    private final InterceptedInteractionFactory underTest = new InterceptedInteractionFactory(profile);

    @Test
    void buildWithNoElapsedTimeRequestAndResponseHeadersHttpStatusAndHttpMethod() {
        InterceptedInteraction result = underTest.buildFrom(body, traceId, requestHeaders, serviceName, target, path, type);

        assertThat(result.getBody(), is(body));
        assertThat(result.getTraceId(), is(traceId));
        assertThat(result.getRequestHeaders(), is(requestHeaders));
        assertThat(result.getServiceName(), is(serviceName));
        assertThat(result.getTarget(), is(target));
        assertThat(result.getPath(), is(path));
        assertThat(result.getProfile(), is(profile));
        assertThat(result.getType(), is(type));

        assertThat(result.getCreatedAt(), is(not(nullValue())));
        assertThat(result.getElapsedTime(), is(nullValue()));
        assertThat(result.getHttpMethod(), is(nullValue()));
        assertThat(result.getHttpStatus(), is(nullValue()));
        assertThat(result.getResponseHeaders(), is(anEmptyMap()));
    }

    @Test
    void buildWithNoElapsedTimeAndResponseHeaders() {
        InterceptedInteraction result = underTest.buildFrom(body, requestHeaders, traceId, serviceName, target, path, httpStatus, httpMethod, type);

        assertThat(result.getBody(), is(body));
        assertThat(result.getTraceId(), is(traceId));
        assertThat(result.getRequestHeaders(), is(requestHeaders));
        assertThat(result.getServiceName(), is(serviceName));
        assertThat(result.getTarget(), is(target));
        assertThat(result.getPath(), is(path));
        assertThat(result.getProfile(), is(profile));
        assertThat(result.getType(), is(type));
        assertThat(result.getHttpMethod(), is(httpMethod));
        assertThat(result.getHttpStatus(), is(httpStatus));

        assertThat(result.getCreatedAt(), is(not(nullValue())));
        assertThat(result.getElapsedTime(), is(nullValue()));
        assertThat(result.getResponseHeaders(), is(anEmptyMap()));
    }

    @Test
    void buildInterceptedInteractionWithAllProperties() {
        InterceptedInteraction result = underTest.buildFrom(body, requestHeaders, responseHeaders, traceId, serviceName, target, path, httpStatus, elapsedTime, httpMethod, type);

        assertThat(result.getBody(), is(body));
        assertThat(result.getTraceId(), is(traceId));
        assertThat(result.getRequestHeaders(), is(requestHeaders));
        assertThat(result.getResponseHeaders(), is(responseHeaders));
        assertThat(result.getServiceName(), is(serviceName));
        assertThat(result.getTarget(), is(target));
        assertThat(result.getPath(), is(path));
        assertThat(result.getProfile(), is(profile));
        assertThat(result.getType(), is(type));
        assertThat(result.getHttpMethod(), is(httpMethod));
        assertThat(result.getHttpStatus(), is(httpStatus));
        assertThat(result.getElapsedTime(), is(elapsedTime));

        assertThat(result.getCreatedAt(), is(not(nullValue())));
    }
}
