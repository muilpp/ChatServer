package chat.service;


import org.springframework.stereotype.Service;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Service
public class CreateSocketServer {

    public CreateSocketServer() {
        System.out.println("Al constructor");
    }

    public void create() {
        System.out.println("Creo socket!");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("Connection accepted!");

            while (true) {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message = dataInputStream.readUTF();
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
