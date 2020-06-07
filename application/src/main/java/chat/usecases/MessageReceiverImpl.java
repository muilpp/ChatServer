package chat.usecases;

import chat.port.message.MessageReceiver;
import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class MessageReceiverImpl implements MessageReceiver {
    private static final Logger LOGGER = Logger.getLogger(MessageReceiverImpl.class.getName());

    @Override
    public void receiveMessage(Socket socket) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while(true) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                        LOGGER.info("Incoming message -> " + dataInputStream.readUTF());
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
