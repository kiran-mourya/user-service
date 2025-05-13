package com.example.user.service;

import com.example.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User saveUser(User user);

    public List<User> getAllUserDetails();

    public User getUserDetails(Integer id);
    Optional<User> getUserByEmail(String email);

}
