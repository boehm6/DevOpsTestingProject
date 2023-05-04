package project.devOps.DevOpsTesting.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.devOps.DevOpsTesting.model.User;
import project.devOps.DevOpsTesting.model.UserRole;
import project.devOps.DevOpsTesting.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    private UserServiceImpl userService;

    UserRepository userRepository = mock(UserRepository.class);

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testGetUserById() {
        long id = 1L;
        User user = createUser(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        Optional<User> result = userService.getUserById(id);
        assertTrue(result.isPresent());
        assertEquals(user, result.get());
    }

    @Test
    void testGetAllUsers() {
        User user1 = createUser(1L);
        User user2 = createUser(2L);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        List<User> result = userService.getAllUsers();
        assertEquals(2, result.size());
        assertTrue(result.contains(user1));
        assertTrue(result.contains(user2));
    }

    @Test
    void testCreateUser() {
        User user = createUser(1L);
        userService.createUser(user);
        verify(userRepository).save(user);
    }

    @Test
    void testDeleteUser() {
        User user = createUser(1L);
        userService.deleteUser(user);
        verify(userRepository).delete(user);
    }

    public User createUser(long userID) {
        User user = new User();
        user.setUserID(userID);
        user.setEmail("test@hm.edu");
        user.setFirstName("Test");
        user.setLastName("Mustermann");
        user.setUsername("Testuser");
        user.setPassword("Passwort");
        user.setRoles(UserRole.BEWOHNER);
        user.setPhone("0123456789");
        user.setAddress("Musterstraße 1");
        return user;
    }
}