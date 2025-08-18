package com.debuggers.factory;

import com.debuggers.domain.Vehicle;
import com.debuggers.util.Helper;

public class VehicleFactory {

    public static Long createVehicleId() {
        return Helper.generateId(); // Simple ID generation
    }

    public static Vehicle createVehicle(
            Long id,
            String vehicleModel,
            String vehicleType) {
        if (isEmptyOrNullString(vehicleModel) || isEmptyOrNullString(vehicleType)) {
            return null;
        }
        return new Vehicle.Builder()
                .setId(id)
                .setVehicleModel(vehicleModel)
                .setVehicleType(vehicleType)
                .build();
    }

    // ✅ Added convenience method for creating vehicle without ID (auto-generated)
    public static Vehicle createVehicle(
            String vehicleModel,
            String vehicleType) {
        if (isEmptyOrNullString(vehicleModel) || isEmptyOrNullString(vehicleType)) {
            return null;
        }
        return new Vehicle.Builder()
                .setVehicleModel(vehicleModel)
                .setVehicleType(vehicleType)
                .build();
    }

    // ✅ Added method to create a copy of an existing vehicle
    public static Vehicle copyVehicle(Vehicle originalVehicle) {
        if (originalVehicle == null) {
            return null;
        }
        return new Vehicle.Builder()
                .copy(originalVehicle)
                .build();
    }

    // ✅ Simple validation method
    private static boolean isEmptyOrNullString(String str) {
        return str == null || str.trim().isEmpty();
    }
}
