package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.User;
import com.debuggers.factory.DriverFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DriverFactoryTest {
    private static User user1 = UserFactory.createUser(Long.valueOf(1),"FName","LName","mail@mail.com","password");
    private static User user2 = UserFactory.createUser(Long.valueOf(2),"FName","LName","","password");

    private static Driver driver1 = DriverFactory.createDriver(Long.valueOf(1),user1,"null","13","3");
    private static Driver driver2 = DriverFactory.createDriver(Long.valueOf(2),user2,"null","17","7");

    @Test
    @Order(1)
    void testCreateDriver() {
        assertNotNull(driver1);
        System.out.println(driver1.toString());
    }

    @Test
    @Order(2)
    void testCreateDriverWithAllAttributes(){
        assertNotNull(driver2);
        System.out.println(driver2.toString());
    }

    @Test
    @Order(3)
    void testCreateDriverThatFails(){
        assertNotNull(driver2);
        System.out.println(driver2.toString());
    }
}