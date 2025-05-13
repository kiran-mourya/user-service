package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import com.example.user.util.TestUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testSavedUserSuccessfully() {
        User user = new User(9,"siya","siya@gmail.com",new BigInteger("997080"));

        when(userRepository.save(user)).thenReturn(user);
        User found = userService.saveUser(user);
        assert found != null;
        Assertions.assertEquals("siya", found.getName());

    }


    @Test
    public void testGetAllUserDetailSuccessfully() {
        List<User> userList = TestUtility.getAllUserDetails();

        when(userRepository.findAll()).thenReturn(userList);
        List<User> foundUserList = userService.getAllUserDetails();
        assert foundUserList != null;
        Assertions.assertEquals(userList.get(0).getName(), foundUserList.get(0).getName());

    }

    @Test
    public void testFindUserById() {
        User user = new User(6,"raman","raman@gmail.com",new BigInteger("997080"));
        when(userRepository.findById(6)).thenReturn(Optional.of(user));
        User found = userService.getUserDetails(6);
        assert found != null;
        Assertions.assertEquals("raman", found.getName());

    }



}
