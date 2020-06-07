package chat.port.message;

import java.io.DataInputStream;
import java.net.Socket;

public interface MessageReceiver {
    void receiveMessage(Socket socket);
}
