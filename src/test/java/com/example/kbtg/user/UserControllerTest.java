package com.example.kbtg.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserControllerTest {

    String errNotFoundID = "User not found id=";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserService userservice;

    @Test
    public void success_get_user_id_1() {
        // Act
        UserResponse response
                = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, response.getId());
        assertEquals("tharawat", response.getName());
        assertEquals(30, response.getAge());
        // Quiz
        UserResponse expected = new UserResponse(1, "tharawat", 30);
        assertEquals(expected, response);
    }

    @Test
    public void user_not_found_with_user_id_15() {
        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            userservice.getInfo(15);
        });
        assertEquals(errNotFoundID+15, exception.getMessage());
    }

}