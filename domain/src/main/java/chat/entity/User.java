package chat.entity;

import java.net.Socket;

public class User {
    private String name;
    private String ipAddress;
    private Socket socket;

    public User() {}

    public User(String name, String ipAddress, Socket socket) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.socket = socket;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Socket getSocket() {
        return socket;
    }
}