package chat.port.message;

import chat.entity.Message;

import java.net.Socket;

public interface MessageSender {
    void send(Message message);
}
