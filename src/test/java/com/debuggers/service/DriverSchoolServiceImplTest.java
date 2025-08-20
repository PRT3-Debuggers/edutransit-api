package com.debuggers.service;

import com.debuggers.domain.Driver;
import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;
import com.debuggers.domain.School;
import com.debuggers.factory.DriverFactory;
import com.debuggers.factory.DriverSchoolFactory;
import com.debuggers.service.impl.DriverSchoolServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.class)
class DriverSchoolServiceImplTest {

    @Autowired
    private DriverSchoolServiceImpl service;

    DriverschoolId driverschoolId1;

    Driver driver1 = DriverFactory.createDriver("none", "5", "3");

    // School school1 = SchoolFactory.createSchool();
    //
    // private DriverSchool driverSchool1 = DriverSchoolFactory
    // .createDriverSchoolFactory(driverschoolId1,driver1,school1);
    //
    // @Test
    // @Order(5)
    // void getAll() {
    // DriverSchool created = service.create(driverSchool1);
    // System.out.println(driverSchool1);
    // assertNotNull(driverSchool1);
    // }

    @Test
    @Order(1)
    void create() {
    }

    @Test
    @Order(2)
    void read() {
    }

    @Test
    @Order(3)
    void update() {
    }

    @Test
    @Order(4)
    void delete() {
    }
}