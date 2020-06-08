package chat.utils;

import chat.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserUtilsTest {

    private static List<User> userList;

    @BeforeAll
    public static void setUp() {
        userList = Arrays.asList(new User("Joan", "192.168.0.1", null), new User("Joan", "192.168.1.1", new Socket()));
    }

    @Test
    public void getUserAddressTest() {
        String ipAddress = "192.168.0.1";
        Socket socket = UserUtils.getUserAddress(userList, ipAddress);

        assertNotNull(socket);
    }
}