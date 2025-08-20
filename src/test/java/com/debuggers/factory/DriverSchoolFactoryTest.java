package com.debuggers.factory;

import com.debuggers.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

class DriverSchoolFactoryTest {
    private static DriverschoolId driverschoolId = new DriverschoolId();

    private static User user1 = UserFactory.createUser(210L, "First", "Last", "firstLast@mail.com", "Passw0rd!");
    private static final Driver driver1 = DriverFactory.createDriver("vandalism", "15", "7");
    private static School school1 = SchoolFactory.createSchool(310L, "legit primary school", "123 normal road");

    // Initialize the composite ID with proper values
    static {
        driverschoolId.setDriverId(110L);
        driverschoolId.setSchoolId(310L);
    }

    protected static DriverSchool driverschool1 = DriverSchoolFactory.createDriverSchool(driverschoolId, driver1,
            school1);

    @Test
    @Disabled
    void testCreateDriverSchool() {
        assertNotNull(driverschool1);
        System.out.println(driverschool1);
    }

    @Test
    void testCreateUser() {
        assertNotNull(user1);
        System.out.println(user1.toString());
    }
}