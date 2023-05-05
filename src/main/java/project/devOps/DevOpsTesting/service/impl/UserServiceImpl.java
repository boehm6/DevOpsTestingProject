package project.devOps.DevOpsTesting.service.impl;

import org.springframework.stereotype.Service;
import project.devOps.DevOpsTesting.model.User;
import project.devOps.DevOpsTesting.repository.UserRepository;
import project.devOps.DevOpsTesting.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> getUserById(long id) {
    return userRepository.findById(id);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }
}
