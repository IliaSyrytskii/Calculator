package storage;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserStorage {
    private long userId = 1;
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        user.setId(userId++);
        users.add(user);
    }

    public Optional<User> getByUserName (String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
