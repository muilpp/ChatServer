package chat.service;

import chat.entity.Message;
import chat.entity.MessageReceivedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final ApplicationEventPublisher publisher;

    EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(final Message message) {
        publisher.publishEvent(new MessageReceivedEvent(this, message));
    }
}
