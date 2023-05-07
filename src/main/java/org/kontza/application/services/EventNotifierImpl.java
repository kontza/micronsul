package org.kontza.application.services;

import jakarta.inject.Singleton;
import org.kontza.application.port.in.EventNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class EventNotifierImpl implements EventNotifier {
    private static final Logger logger = LoggerFactory.getLogger(EventNotifierImpl.class);

    @Override
    public void notify(String payload) {
        logger.error(">>> Would send '{}'", payload);
    }
}
