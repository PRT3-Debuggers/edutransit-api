package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.Driverschool;
import com.debuggers.domain.DriverschoolId;
import com.debuggers.domain.School;

public class DriverSchoolFactory {
    public static Driverschool createDriverSchool(
            DriverschoolId id,
            Driver driver,
            School school
    ){
        if (
                id == null || driver == null || school == null
        ) {
            return null;
        }
            return new Driverschool.Builder()
                    .setDriverschoolId(id)
                    .setDriver(driver)
                    .setSchool(school)
                    .build();
    }
}
