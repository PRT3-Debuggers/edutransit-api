package com.debuggers.factory;

import com.debuggers.domain.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

class DriverSchoolFactoryTest {
    private static DriverschoolId driverschoolId = new DriverschoolId();

    private static User user1 = UserFactory.createUser(210L,"First","Last","firstLast@mail.com","passw0rd");
    private static Driver driver1 = DriverFactory.createDriver(110L,user1,"vandalism","15","7");
    private static School school1 = SchoolFactory.createSchool(310L,"legit primary school","123 normal road");

    private static Driverschool driverschool1 = DriverSchoolFactory.createDriverSchool(driverschoolId,driver1,school1);

    @Test
    @Disabled
    void testCreateDriverSchool(){
        driverschoolId.setDriverId(110L);
        driverschoolId.setSchoolId(310L);
        assertNotNull(driverschool1);
        System.out.println(driverschool1.toString());
    }

    @Test
    void testCreateUser(){
        assertNotNull(user1);
        System.out.println(user1.toString());
    }
}