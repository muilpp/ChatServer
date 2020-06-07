package chat.usecases;

import chat.entity.Message;
import chat.port.message.MessageSender;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class MessageSenderImpl implements MessageSender {
    private static final Logger LOGGER = Logger.getLogger(MessageSenderImpl.class.getName());

    @Override
    public void send(Message message) {
        LOGGER.info("Sending message -> " + message.getContent());
    }
}
