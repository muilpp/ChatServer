package chat.usecases;

import chat.entity.Message;
import chat.port.message.MessageSender;
import chat.port.user.UserRepository;
import chat.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MessageSenderImpl implements MessageSender {
    private static final Logger LOGGER = Logger.getLogger(MessageSenderImpl.class.getName());

    @Autowired
    private UserRepository userRepository;

    @Override
    public void send(Message message) {
        LOGGER.info("Sending message -> " + message.getContent());

        Socket receiverSocket = UserUtils.getUserAddress(userRepository.getAllUsers(), message.getFrom());
        if (receiverSocket == null)
            return;

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(receiverSocket.getOutputStream());
            dataOutputStream.writeUTF(message.getContent());
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}

