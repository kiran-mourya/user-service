package com.example.user.response;

public class ResultCode {
    private String message;
    private int statusCode;
    private String description;
    private String userId;

    public ResultCode(String message, int statusCode, String description, String userId) {
        this.message = message;
        this.statusCode = statusCode;
        this.description = description;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
