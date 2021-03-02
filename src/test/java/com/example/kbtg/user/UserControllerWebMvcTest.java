package com.example.kbtg.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerWebMvcTest {

    String errNotFoundID = "User not found id=";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void failure_user_not_found() throws Exception{

        when(userService.getInfo(15))
                .thenThrow(new UserNotFoundException(errNotFoundID+15));

        // Act
        MvcResult mvcResult = mvc.perform(get("/user/15")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        // String => JSON Message
        String jsonResult = mvcResult.getResponse().getContentAsString();
        // Convert JSON message to Object/POJO
        ObjectMapper mapper = new ObjectMapper();
        ErrorResponse response
                = mapper.readValue(jsonResult, ErrorResponse.class);
        // Assert
        assertEquals(1234, response.getCode());
        assertEquals(errNotFoundID+15, response.getMessage());
    }
}
