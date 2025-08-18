package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.DriverVehicle;
import com.debuggers.domain.DrivervehicleId;
import com.debuggers.domain.Vehicle;
import com.debuggers.util.Helper;

public class DriverVehicleFactory {

    public static DriverVehicle createDriverVehicle(
            DrivervehicleId id, Vehicle vehicle, Driver driver
    ){
        if (
                Helper.IsEmptyOrNullString(String.valueOf(id))|| Helper.IsEmptyOrNullString(String.valueOf(vehicle))||
                        Helper.IsEmptyOrNullString(String.valueOf(driver))
        ){
            return null;
        }

        return new DriverVehicle.Builder()
                .setDriver(driver)
                .setId(id)
                .setVehicle(vehicle)
                .build();
    }
}
