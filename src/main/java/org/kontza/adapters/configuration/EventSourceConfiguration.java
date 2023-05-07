package org.kontza.adapters.configuration;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.Setter;

@Singleton
public class EventSourceConfiguration {
    @Value("${micronaut.application.name}-${micronaut.server.port}")
    private String eventSource;

    public String getEventSource() {
        return eventSource;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }
}
