package com.debuggers.factory;

import com.debuggers.domain.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(
            Long id,
            String vehicleModel,
            String vehicleType
    ){
        if(
                id == null  ||  vehicleModel == null  ||  vehicleType == null
        ) {
            return null;
        }
        return new Vehicle.Builder()
                .setId(id)
                .setVehicleModel(vehicleModel)
                .setVehicleType(vehicleType)
                .build();
    }
}
