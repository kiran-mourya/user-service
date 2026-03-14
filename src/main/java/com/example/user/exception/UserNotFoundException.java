package com.example.user.exception;

public class UserNotFoundException extends RuntimeException{

    private final String userId;

    public UserNotFoundException(String message, String userId) {
        super(message);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
