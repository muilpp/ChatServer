package chat.entity;

import org.springframework.context.ApplicationEvent;


public class MessageReceivedEvent extends ApplicationEvent {
    private Message message;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MessageReceivedEvent(Object source, Message message) {
        super(source);
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
