package org.kontza.adapters.web;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

@Controller("/trigger")
public class TriggerController {
    private static final Logger logger = LoggerFactory.getLogger(TriggerController.class);

    @Get()
    public Mono<String> doit() {
        logger.error(">>> Not implemented, yet!");
        return Mono.just("OK");
    }
}
