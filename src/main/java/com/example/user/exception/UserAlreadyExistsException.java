package com.example.user.exception;

public class UserAlreadyExistsException extends RuntimeException{
    private Integer userId ;

    public UserAlreadyExistsException(String message,Integer userId) {
        super(message);
        this.userId = userId;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
