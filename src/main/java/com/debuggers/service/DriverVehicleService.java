package com.debuggers.service;

import com.debuggers.domain.DriverVehicle;
import com.debuggers.domain.DrivervehicleId;

import java.util.List;

public interface DriverVehicleService extends IService<DriverVehicle, DrivervehicleId>{
    List<DriverVehicle> getAllDriverVehicles();
}
