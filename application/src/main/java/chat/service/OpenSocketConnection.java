package chat.service;

import chat.entity.MessageReceivedEvent;
import chat.port.message.MessageReceiver;
import chat.port.message.MessageSender;
import chat.usecases.ConnectionOpener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OpenSocketConnection implements ConnectionOpener {
    private static final Logger LOGGER = Logger.getLogger(OpenSocketConnection.class.getName());

    @Autowired
    private MessageReceiver messageReceiver;

    @Autowired
    private MessageSender messageSender;

    public void open() {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                LOGGER.info("Server Socket ready for connection");
                messageReceiver.receiveMessage(serverSocket.accept());
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
