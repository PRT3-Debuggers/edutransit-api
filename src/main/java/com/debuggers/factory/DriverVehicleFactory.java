package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.Drivervehicle;
import com.debuggers.domain.DrivervehicleId;
import com.debuggers.domain.Vehicle;

public class DriverVehicleFactory {
    public static Drivervehicle createDriverVehicle(
            Vehicle vehicle,
            Driver driver,
            DrivervehicleId id
    ){
        if(
                vehicle == null ||  driver == null  ||  id == null
        ){
            return null;
        }
        return new Drivervehicle.Builder()
                .setVehicle(vehicle)
                .setDriver(driver)
                .setId(id)
                .build();
    }
}
