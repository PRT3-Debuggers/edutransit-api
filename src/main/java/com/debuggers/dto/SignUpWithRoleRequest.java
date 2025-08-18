package com.debuggers.dto;

public class SignUpWithRoleRequest {
  private String firstName;
  private String lastName;
  private String emailAddress;
  private String password;
  private String role;

  // Default constructor
  public SignUpWithRoleRequest() {
  }

  // Parameterized constructor
  public SignUpWithRoleRequest(String firstName, String lastName, String emailAddress, String password, String role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
    this.password = password;
    this.role = role;
  }

  // Getters
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getPassword() {
    return password;
  }

  public String getRole() {
    return role;
  }

  // Setters
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "SignUpWithRoleRequest{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        ", password='" + password + '\'' +
        ", role='" + role + '\'' +
        '}';
  }
}
