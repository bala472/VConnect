package com.vconnect.createuser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testStoreUserDetails() {
        // Create the User object with all necessary fields
        User user = new User(
                "vasanth@gmail.com",
                "vasanth",
                LocalDate.of(2001, 5, 5),
                "9361275508",
                "car",
                "Service Provider",
                "DL1234567890",
                "TN01AB1234",
                "https://www.jagranimages.com/images/newimg/02052023/rc(1).jpg",
                "https://img.freepik.com/free-vector/flat-design-driving-license-template_23-2149944210.jpg?size=626&ext=jpg",
                "password123"
        );

        // Call the storeUserDetails method
        boolean result = userService.createUser(user);

        // Assert that the result is true, indicating successful storage
        assertTrue(result);
    }
}
