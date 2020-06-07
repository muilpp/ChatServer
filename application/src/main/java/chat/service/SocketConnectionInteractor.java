package chat.service;

import chat.entity.MessageReceivedEvent;
import chat.entity.User;
import chat.port.message.MessageReceiver;
import chat.port.message.MessageSender;
import chat.port.user.UserRepository;
import chat.usecases.ConnectionOpener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class SocketConnectionInteractor implements ConnectionOpener {
    private static final Logger LOGGER = Logger.getLogger(SocketConnectionInteractor.class.getName());

    @Autowired
    private MessageReceiver messageReceiver;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageSender messageSender;

    public void open() {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                LOGGER.info("Server Socket ready for connection");
                Socket socket = serverSocket.accept();
                userRepository.create(new User("", socket.getRemoteSocketAddress().toString(), socket));
                messageReceiver.receiveMessage(socket);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @EventListener
    public void handleUserCreatedEvent(MessageReceivedEvent event) {
        LOGGER.info("Message event received");
        messageSender.send(event.getMessage());
    }
}
