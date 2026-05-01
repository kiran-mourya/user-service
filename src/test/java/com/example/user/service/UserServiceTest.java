package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;
import com.example.user.response.UserResponseDetails;
import com.example.user.util.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddUserSuccessfully() {

        UserRequestDetails request = new UserRequestDetails();
        request.setId("1001");
        request.setEmailAddress("raman@gmail.com");

        User user = new User();
        user.setUid("1001");
        user.setEmailAddress("raman@gmail.com");

        UserResponseDetails responseDetails = new UserResponseDetails();
        responseDetails.setEmailAddress("raman@gmail.com");

        when(userRepository.findUserByEmailAddress(request.getEmailAddress())).thenReturn(false);
        when(modelMapper.map(request, User.class)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        when(modelMapper.map(user, UserResponseDetails.class)).thenReturn(responseDetails);

        ApiResponse response = userService.addUser(request);

        assertNotNull(response);
        assertEquals("user saved successfully !", response.getResultCode().getMessage());
    }

    @Test
    void testGetAllUsersSuccessfully() {

        User user1 = new User();
        user1.setUid("1");

        User user2 = new User();
        user2.setUid("2");

        List<User> users = Arrays.asList(user1, user2);

        UserResponseDetails res1 = new UserResponseDetails();
        UserResponseDetails res2 = new UserResponseDetails();

        when(userRepository.findAll()).thenReturn(users);
        when(modelMapper.map(user1, UserResponseDetails.class)).thenReturn(res1);
        when(modelMapper.map(user2, UserResponseDetails.class)).thenReturn(res2);

        ApiResponse response = userService.getAllUsers();

        assertNotNull(response);
        assertEquals(200, response.getResultCode().getStatusCode());
    }
    @Test
    void testGetUserByIdSuccessfully() {

        String userId = "1";

        User user = new User();
        user.setUid(userId);
        user.setEmailAddress("raman@gmail.com");

        UserResponseDetails responseDetails = new UserResponseDetails();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(modelMapper.map(user, UserResponseDetails.class)).thenReturn(responseDetails);

        ApiResponse response = userService.getUsersById(userId);

        assertNotNull(response);
        assertEquals(200, response.getResultCode().getStatusCode());
    }
    @Test
    void testDeleteUserSuccessfully() {

        String userId = "1";

        User user = new User();
        user.setUid(userId);

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).deleteById(userId);

        ApiResponse response = userService.deleteUser(userId);

        assertNotNull(response);
        assertEquals(204, response.getResultCode().getStatusCode());
    }
}
