package chat.usecases;

import chat.entity.Message;
import chat.port.message.MessageReceiver;
import chat.service.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MessageReceiverImpl implements MessageReceiver {
    private static final Logger LOGGER = Logger.getLogger(MessageReceiverImpl.class.getName());

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public void receiveMessage(Socket socket) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while(true) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        String incomingMessage = dataInputStream.readUTF();
                        LOGGER.info("Incoming message -> " + incomingMessage);
                        eventPublisher.publishEvent(Message.create(socket.getRemoteSocketAddress().toString(), "", incomingMessage));
                    } catch (IOException e) {
                        LOGGER.log(Level.SEVERE, e.getMessage(), e);
                        try {
                            socket.close();
                        } catch (IOException ioException) {
                            LOGGER.log(Level.SEVERE, e.getMessage(), e);
                        }
                        break;
                    }
                }
            }
        }.start();
    }
}
