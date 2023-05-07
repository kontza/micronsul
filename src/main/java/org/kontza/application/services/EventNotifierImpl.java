package org.kontza.application.services;

import jakarta.inject.Singleton;
import org.kontza.application.port.in.EventNotifier;
import org.kontza.application.port.out.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class EventNotifierImpl implements EventNotifier {
    private static final Logger logger = LoggerFactory.getLogger(EventNotifierImpl.class);
    private final MessageSender messageSender;

    public EventNotifierImpl(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void notify(String payload) {
        messageSender.sendMessage(payload);
    }
}
