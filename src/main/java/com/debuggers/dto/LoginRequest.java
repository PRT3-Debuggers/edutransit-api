package com.debuggers.dto;

public class LoginRequest {
    private String emailAddress;
    private String password;

    // Default constructor
    public LoginRequest() {
    }

    // Parameterized constructor
    public LoginRequest(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    // Getters
    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
