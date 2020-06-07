package chat.port.user;

import chat.entity.User;

import java.util.List;

public interface UserRepository {
    boolean create(User user);
    boolean delete(User user);
    List<User> getAllUsers();
}
