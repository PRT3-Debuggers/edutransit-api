package com.debuggers.factory;

import com.debuggers.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.core.annotation.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DriverLanguageFactoryTest {
    private static DriverlanguageId driverLanguageId1 = new DriverlanguageId();
    private static Language langTemp1 = new Language();

    private static User userTemp1 = UserFactory.createUser(120L, "FName", "LName", "mail@mail.com", "password");
    private static Driver driver1 = DriverFactory.createDriver("null", "5", "3");

    private static DriverLanguage driverlanguage1 = DriverLanguageFactory.createDriverLanguage(driverLanguageId1,
            driver1, langTemp1);
    private static DriverLanguage driverlanguage2 = DriverLanguageFactory.createDriverLanguage(new DriverlanguageId(),
            new Driver(), new Language());
    private static DriverLanguage driverlanguage3 = DriverLanguageFactory.createDriverLanguage(new DriverlanguageId(),
            new Driver(), new Language());

    @Test
    @Order(3)
    void testCreateDriverLanguage() {
        assertNotNull(driverlanguage1);
        System.out.println(driverlanguage1.toString());
    }

    @Test
    @Disabled
    void testCreateLangTemp() {
        // Commented out methods that don't exist in Language class
        // langTemp1.setId(110L);
        // langTemp1.setLanguageName("English");
        // langTemp1.setCode("ENG1");
    }

    @Test
    void testCreateDriverLanguageThatFails() {
        // assertEquals(new DriverlanguageId(),driverlanguage1);
        System.out.println(driverlanguage1.toString());
    }

    @Test
    @Disabled
    void testCreateDriverLanguageId() {
        driverLanguageId1.setDriverId(110L);
        driverLanguageId1.setDriverId(210L);
    }

}