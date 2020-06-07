package chat.utils;

import chat.entity.User;

import java.net.Socket;
import java.util.List;

public class UserUtils {

    public static Socket getUserAddress(List<User> userList, String ipAddress) {
        for (User user : userList) {
            if (!user.getIpAddress().equalsIgnoreCase(ipAddress))
                return user.getSocket();
        }

        return null;
    }
}
