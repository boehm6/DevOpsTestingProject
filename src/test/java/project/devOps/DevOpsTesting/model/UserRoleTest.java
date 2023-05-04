package project.devOps.DevOpsTesting.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRoleTest {

    @Test
    public void testUserRole() {
        UserRole role1 = UserRole.BEWOHNER;
        UserRole role2 = UserRole.FREUND;

        Assertions.assertEquals("BEWOHNER", role1.toString());
        Assertions.assertEquals("FREUND", role2.toString());
        Assertions.assertNotEquals(role1, role2);
    }
}

