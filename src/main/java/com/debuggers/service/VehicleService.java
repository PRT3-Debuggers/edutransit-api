package com.debuggers.service;

import com.debuggers.domain.Vehicle;

import java.util.List;

public interface VehicleService extends Service<Vehicle, Long> {
    List<Vehicle> getAllVehicles();
}
