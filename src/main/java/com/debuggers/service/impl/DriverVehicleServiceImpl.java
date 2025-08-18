package com.debuggers.service.impl;

import com.debuggers.domain.DriverVehicle;
import com.debuggers.domain.DrivervehicleId;
import com.debuggers.repository.DriverVehicleRepository;
import com.debuggers.service.DriverVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverVehicleServiceImpl implements DriverVehicleService {

    @Autowired
    private static DriverVehicleService service;

    private DriverVehicleRepository repository;

    @Override
    public List<DriverVehicle> getAllDriverVehicles() {
        return this.repository.getAllDriverVehicles();
    }

    @Override
    public DriverVehicle create(DriverVehicle driverVehicle) {
        return this.repository.save(driverVehicle);
    }

    @Override
    public DriverVehicle read(DrivervehicleId id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public DriverVehicle update(DriverVehicle driverVehicle) {
        return this.repository.save(driverVehicle);
    }

    @Override
    public void delete(DrivervehicleId id) {
        this.repository.deleteById(id);
    }
}
