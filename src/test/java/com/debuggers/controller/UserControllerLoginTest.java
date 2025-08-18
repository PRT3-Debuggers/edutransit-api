package com.debuggers.controller;

import com.debuggers.dto.LoginRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserControllerLoginTest {

    @Test
    void testLoginRequestCreation() {
        LoginRequest loginRequest = new LoginRequest("test@example.com", "password123");
        
        assertNotNull(loginRequest);
        assertEquals("test@example.com", loginRequest.getEmailAddress());
        assertEquals("password123", loginRequest.getPassword());
    }

    @Test
    void testLoginRequestSetters() {
        LoginRequest loginRequest = new LoginRequest();
        
        loginRequest.setEmailAddress("new@example.com");
        loginRequest.setPassword("newpassword");
        
        assertEquals("new@example.com", loginRequest.getEmailAddress());
        assertEquals("newpassword", loginRequest.getPassword());
    }

    @Test
    void testLoginRequestToString() {
        LoginRequest loginRequest = new LoginRequest("user@test.com", "secret");
        String result = loginRequest.toString();
        
        assertTrue(result.contains("user@test.com"));
        assertTrue(result.contains("secret"));
        assertTrue(result.contains("LoginRequest"));
    }
}
