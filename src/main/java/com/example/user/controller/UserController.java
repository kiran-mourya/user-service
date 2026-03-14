package com.example.user.controller;

import com.example.user.request.UserRequestDetails;
import com.example.user.response.ApiResponse;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create-users")
    public ResponseEntity<ApiResponse> addUser(@RequestBody UserRequestDetails userRequestDetails) {
        ApiResponse apiResponse = userService.addUser(userRequestDetails);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/user-details")
    public ResponseEntity<ApiResponse> getAllUsers() {
        ApiResponse apiResponse = userService.getAllUsers();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/user-details/{userId}")
    public ResponseEntity<ApiResponse> getUsersById(@PathVariable String userId) {
        ApiResponse apiResponse = userService.getUsersById(userId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable String userId) {
        ApiResponse apiResponse = userService.deleteUser(userId);
        return new ResponseEntity<>(apiResponse, HttpStatus.NO_CONTENT);
    }

}