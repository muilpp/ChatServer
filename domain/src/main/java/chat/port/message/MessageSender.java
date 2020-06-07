package chat.port.message;

import chat.entity.Message;

public interface MessageSender {
    void send(Message message);
}
