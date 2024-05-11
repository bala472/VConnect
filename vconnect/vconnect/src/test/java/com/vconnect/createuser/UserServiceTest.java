package com.vconnect.createuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testStoreUserDetails() {
        // Create the User object
        User user = new User("bala@gmail.com", "Bala", LocalDate.of(2001, 05, 05), "9361276808");

        // Call the storeUserDetails method
        boolean result = userService.storeUserDetails(user);

        // Assert that the result is true, indicating successful storage
        assert(result); // or use appropriate assertions based on your testing framework
    }
}
