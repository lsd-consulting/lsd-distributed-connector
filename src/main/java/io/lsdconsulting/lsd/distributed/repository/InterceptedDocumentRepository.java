package io.lsdconsulting.lsd.distributed.repository;

import io.lsdconsulting.lsd.distributed.model.InterceptedInteraction;

import java.util.List;

public interface InterceptedDocumentRepository {
    void save(final InterceptedInteraction interceptedInteraction);
    List<InterceptedInteraction> findByTraceIds(final String... traceId);
}
