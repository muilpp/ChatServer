package chat.database;

import chat.entity.User;
import chat.port.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class InMemoryRepository implements UserRepository {
    private static final Logger LOGGER = Logger.getLogger(InMemoryRepository.class.getName());
    private static List<User> userList = new ArrayList<>();

    @Override
    public boolean create(User user) {
        userList.add(user);
        return userList.contains(user);
    }

    @Override
    public boolean delete(User user) {
        if (userList.contains(user)) {
            userList.remove(user);
            return userList.contains(user);
        }

        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
