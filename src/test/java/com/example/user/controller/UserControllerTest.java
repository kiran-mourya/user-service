
package com.example.user.controller;

import com.example.user.service.UserService;
import com.example.user.config.TestConfig;
import com.example.user.entity.User;
import com.example.user.util.JsonParser;
import com.example.user.util.TestUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    public void shouldSaveUserInDatabaseSuccessfully() throws Exception {
        User user = getUserDetails();
        when(userService.saveUser(any(User.class))).thenReturn(user);
        MvcResult result =  mockMvc.perform(
               post("/users")
                       .contentType(MediaType.APPLICATION_JSON_VALUE)
                       .content(objectMapper.writeValueAsString(user))
                       )
                .andExpect(status().isCreated())
                .andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        User responseUser = objectMapper.readValue(jsonResponse, User.class);

        assertEquals(user.getId(),responseUser.getId());
    }

    @Test
    public void testGetUserById() throws Exception {
        User user = new User(6,"raman","raman@gmail.com",new BigInteger("997080"));
        Integer userId = 6;
        when(userService.getUserDetails(userId)).thenReturn(user);
        String jsonContent = TestUtility.readJsonFile("src/test/resources/data/single-user.json");
        User users = JsonParser.parseSingleUser(jsonContent);
        mockMvc.perform(MockMvcRequestBuilders.get("/users-details/6"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(6))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("raman"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("raman@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.contact").value("997080"));
    }

    @Test
    public void testGetAllUsersSuccessfully() throws Exception {

        String jsonContent = TestUtility.readJsonFile("src/test/resources/data/users.json");
        List<User> users = JsonParser.parseUsers(jsonContent);
        when(userService.getAllUserDetails()).thenReturn(users);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/users-details"))
                .andExpect(status().isOk());

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            resultActions
                    .andExpect(MockMvcResultMatchers.jsonPath("$[" + i + "].id").value(user.getId()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[" + i + "].name").value(user.getName()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[" + i + "].email").value(user.getEmail()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$[" + i + "].contact").value(user.getContact()));
        }

    }


    private User getUserDetails() {
        User user = new User();
        user.setId(10);
        user.setContact(new BigInteger("7689"));
        user.setEmail("ss@gmail.com");
        user.setName("ss");
        return user;
    }

}