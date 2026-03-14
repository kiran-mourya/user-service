package com.example.user.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    private String id;
    private String userName;
    private String emailAddress;
    private Long phoneNumber;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String role;
    private String password;

    public User(){}

    public User(String uuid, String userName, String emailAddress, Long phoneNumber, LocalDate createdDate, LocalDate modifiedDate, String role, String password) {
        this.id = uuid;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.role = role;
        this.password = password;
    }

    public String getUid() {
        return id;
    }

    public void setUid(String uuid) {
        this.id = uuid;
    }

    public String getUserName() {  return userName; }
    public void setuserName(String userName) {
        this.userName = userName;
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

    public String getId() {
        return id;
    }

    public void setId(String uuid) {
        this.id = uuid;
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
