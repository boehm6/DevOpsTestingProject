package project.devOps.DevOpsTesting.service;

import project.devOps.DevOpsTesting.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserById(long id);

    List<User> getAllUsers();

    void createUser(User user);

    void deleteUser(User user);
}
