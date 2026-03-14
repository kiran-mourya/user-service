package com.example.user.response;

import java.time.LocalDate;

public class UserResponseDetails {
    private String username;
    private String emailAddress;
    private Long phoneNumber;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String role;
    private String password;

    public UserResponseDetails(){}

    public UserResponseDetails(String username,String emailAddress, Long phoneNumber,LocalDate createdDate, LocalDate modifiedDate, String role, String password) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.role = role;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
