package com.example.user.service;


import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;

public interface UserService {

    public ApiResponse addUser(UserRequestDetails userRequestDetails);

    ApiResponse getAllUsers();

    ApiResponse getUsersById(String userId);

    ApiResponse deleteUser(String userId);
}
