package com.debuggers.dto;

public class UpdateParentRequest {
    private Long parentId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;

    // Default constructor
    public UpdateParentRequest() {}

    // Constructor with all fields
    public UpdateParentRequest(Long parentId, String firstName, String lastName, String emailAddress, String password) {
        this.parentId = parentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    // Getters and Setters
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UpdateParentRequest{" +
                "parentId=" + parentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
} 