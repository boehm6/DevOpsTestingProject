package project.devOps.DevOpsTesting.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    @Test
    public void testUserConstructor() {
        User user = new User();
        Assertions.assertNotNull(user);
    }

    @Test
    public void testUserProperties() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("testpassword");
        user.setFirstName("Test");
        user.setLastName("User");
        user.setAddress("123 Test Street");
        user.setPhone(1234567890);
        user.setEmail("testuser@example.com");
        user.setRoles(UserRole.BEWOHNER);

        Assertions.assertEquals("testuser", user.getUsername());
        Assertions.assertEquals("testpassword", user.getPassword());
        Assertions.assertEquals("Test", user.getFirstName());
        Assertions.assertEquals("User", user.getLastName());
        Assertions.assertEquals("123 Test Street", user.getAddress());
        Assertions.assertEquals(1234567890L, user.getPhone());
        Assertions.assertEquals("testuser@example.com", user.getEmail());
        Assertions.assertEquals(UserRole.BEWOHNER, user.getRoles());
    }

    @Test
    public void testUserBorrows() {
        User user = new User();
        List<Borrow> borrows = new ArrayList<>();

        Borrow borrow1 = new Borrow();
        borrow1.setBorrower(user);
        borrows.add(borrow1);

        Borrow borrow2 = new Borrow();
        borrow2.setBorrower(user);
        borrows.add(borrow2);

        user.setBorrows(borrows);

        Assertions.assertEquals(2, user.getBorrows().size());
        Assertions.assertEquals(user, user.getBorrows().get(0).getBorrower());
        Assertions.assertEquals(user, user.getBorrows().get(1).getBorrower());
    }
}
