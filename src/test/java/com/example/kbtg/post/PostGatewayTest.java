package com.example.kbtg.post;

import com.example.kbtg.user.UserNotFoundException;
import com.example.kbtg.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PostGatewayTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    public void success_with_id_1() {
        Optional<PostResponse> resp = postGateway.getPostById(1);
        //Actual
        assertTrue(resp.isPresent());
        assertEquals(resp.get().getId(), 1);
    }

    @Test
    public void should_return_empty_when_exception_is_occured() {
        Optional<PostResponse> resp = postGateway.getPostById(0);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            resp.get().getId();
        });
        assertEquals("No value present", exception.getMessage());
    }

}