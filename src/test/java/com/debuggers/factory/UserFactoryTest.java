package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    private static User userLewis = UserFactory.createUser(UserFactory.createUserId(),"Bonga", "Velem", "bongavelem@outlook.com","Bong@14");

    private static User user2  = UserFactory.createUser(
            UserFactory.createUserId(),
            " ",
            "Velem",
            "not-an-email",
            "Bonga@14"
    );

    private static User loginLewis = UserFactory.loginUser("bongavelem@outlook.com", "Bong@14");

    private static User loginFail = UserFactory.loginUser("", "Running@Man1");





    @Test
    void testCreateUserSuccess() {
        assertNotNull(userLewis);
        System.out.println("New User: " + userLewis);

    }

    @Test
    void testCreateUserFail_invalidEmail() {
        assertNull(user2, "Should return null for invalid email");
        System.out.println(user2);
    }

    User login = UserFactory.loginUser(
            "bongavelem@outlook.com",
            "Bonga@14"
    );

    @Test
    void testLoginUserSuccess() {
        assertNotNull(loginLewis);
        System.out.println("Logged in: " + loginLewis);

    }



    @Test
    void testLoginUserFail_invalidPassword() {
        assertNull(loginFail, "Should return null for empty password");
        System.out.println(loginFail);
    }



    @Test
    void testLoginUserFail_invalidEmail() {
        assertNull(loginFail, "Should return null for empty password");
        System.out.println(loginFail);

    }
}