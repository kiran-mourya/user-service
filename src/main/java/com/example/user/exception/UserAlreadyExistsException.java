package com.example.user.exception;

public class UserAlreadyExistsException extends RuntimeException{
    private String userId ;

    public UserAlreadyExistsException(String message,String userId) {
        super(message);
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
