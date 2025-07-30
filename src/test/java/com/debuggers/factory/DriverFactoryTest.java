package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverFactoryTest {

    private Driver driverLerclerc;
    private Driver driverFail;

    @BeforeEach
    void setUp() {
        // Initialize before each test
        driverLerclerc = DriverFactory.createDriver("none", "5", "3");
        driverFail = DriverFactory.createDriver("first offence", " ", "3");
    }

    @Test
    void createDriverId() {
        assertNotNull(driverLerclerc);
        System.out.println(driverLerclerc.toString() + " — Test is successful, keep going!");
    }

    @Test
    void createDriver() {
        assertNull(driverFail);
        System.out.println("Driver is null — there is an error as expected!");
    }
}