import static org.junit.jupiter.api.Assertions.assertEquals;

import base.tests.UserJava;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private UserJava user;

    @BeforeEach
    public void setUp() {
        user = new UserJava();
    }

    @Test
    public void testUsername() {
        String username = "testUser";
        user.setUsername(username);
        assertEquals(username, user.getUsername(), "Username should be set and retrieved correctly");
    }

    @Test
    public void testPassword() {
        String password = "testPassword";
        user.setPassword(password);
        assertEquals(password, user.getPassword(), "Password should be set and retrieved correctly");
    }
}