package com.debuggers.factory;

import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;
import com.debuggers.util.Helper;

public class DriverSchoolFactory {

    public static DriverSchool createDriverSchoolFactory(
            DriverschoolId id, Driver driver, School school
    ){
        if (
                Helper.IsEmptyOrNullString(String.valueOf(id)) ||
                        Helper.IsEmptyOrNullString(String.valueOf(school)) ||
                        Helper.IsEmptyOrNullString(String.valueOf(driver))

        ) {
            return null;
        }

        return new DriverSchool.Builder()
                .setDriver(driver)
                .setSchool(school)
                .setDriverschoolId(id)
                .build();
    }
}
