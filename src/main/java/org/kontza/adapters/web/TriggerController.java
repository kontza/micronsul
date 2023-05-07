package org.kontza.adapters.web;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import org.kontza.application.port.in.EventNotifier;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Controller("/trigger")
public class TriggerController {
    private final EventNotifier eventNotifier;

    public TriggerController(EventNotifier eventNotifier) {
        this.eventNotifier = eventNotifier;
    }

    @Get()
    public Mono<String> doit(@Nullable @QueryValue String message) {
        eventNotifier.notify(Optional.ofNullable(message).orElse("TRIGGERED!"));
        return Mono.just("OK");
    }
}
