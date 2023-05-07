package org.kontza.application.services;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.event.model.EventParams;
import jakarta.inject.Singleton;
import org.kontza.adapters.configuration.EventSourceConfiguration;
import org.kontza.application.port.out.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class MessageSenderImpl implements MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSenderImpl.class);
    public static final String STREAM_OUT = "notifyStream";
    private final ConsulClient consulClient;
    private final EventSourceConfiguration eventSourceConfiguration;

    public MessageSenderImpl(EventSourceConfiguration eventSourceConfiguration) {
        this.eventSourceConfiguration = eventSourceConfiguration;
        this.consulClient = new ConsulClient("localhost");
    }

    @Override
    public void sendMessage(String payload) {
        var msg = String.format("{\"eventSource\":\"%s\",\"command\":\"%s\"}",
            eventSourceConfiguration.getEventSource(),
            payload
        );
        consulClient.eventFire(STREAM_OUT,
            msg,
            new EventParams(),
            new QueryParams(""));
    }
}
