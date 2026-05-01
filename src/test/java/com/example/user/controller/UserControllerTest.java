
package com.example.user.controller;

import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;
import com.example.user.service.UserService;
import com.example.user.config.TestConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import(TestConfig.class)
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testAddUserSuccessfully() throws Exception {

        UserRequestDetails request = new UserRequestDetails();
        request.setUsername("Raman Kumar");
        request.setEmailAddress("raman@gmail.com");
        request.setPhoneNumber(Long.valueOf("9970800000"));

        ApiResponse response = new ApiResponse();
        response.setResponse("User created successfully");

        Mockito.when(userService.addUser(Mockito.any(UserRequestDetails.class)))
                .thenReturn(response);

        mockMvc.perform(post("/users/create-users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }
    @Test
    void testGetUserByIdSuccessfully() throws Exception {

        String userId = "6";

        ApiResponse response = new ApiResponse();
        response.setResponse("User fetched successfully");

        Mockito.when(userService.getUsersById(userId)).thenReturn(response);

        mockMvc.perform(get("/users/user-details/{userId}", userId))
                .andExpect(status().isOk());
    }
    @Test
    void testGetAllUsersSuccessfully() throws Exception {

        ApiResponse response = new ApiResponse();
        response.setResponse("Users fetched successfully");

        Mockito.when(userService.getAllUsers()).thenReturn(response);

        mockMvc.perform(get("/users/user-details"))
                .andExpect(status().isOk());
    }


}