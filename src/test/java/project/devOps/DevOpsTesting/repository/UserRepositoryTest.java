package project.devOps.DevOpsTesting.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import project.devOps.DevOpsTesting.model.User;
import project.devOps.DevOpsTesting.model.UserRole;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById() {
        User user = createUser(1L);
        User savedUser = userRepository.save(user);
        Optional<User> result = userRepository.findById(savedUser.getUserID());
        assertTrue(result.isPresent());
        assertEquals(user.getFirstName(), result.get().getFirstName());
    }

    @Test
    public void testSave() {
        User user = createUser(1L);
        User savedUser = userRepository.save(user);
        assertNotNull(savedUser.getUserID());
        assertEquals(user.getFirstName(), savedUser.getFirstName());
    }

    @Test
    public void testDelete() {
        User user = createUser(1L);
        User savedUser = userRepository.save(user);
        userRepository.delete(savedUser);
        Optional<User> result = userRepository.findById(savedUser.getUserID());
        assertFalse(result.isPresent());
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
