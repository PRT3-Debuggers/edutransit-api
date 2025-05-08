package com.debuggers.service;

import com.debuggers.domain.Vehicle;
import com.debuggers.repository.IVehicleRepository;

import java.util.List;

public class VehicleService {
    private final IVehicleRepository vehicleRepository;

    public VehicleService(IVehicleRepository vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle create(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Vehicle read(Long id){
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<Vehicle> readAll(){
        return vehicleRepository.findAll();
    }

    public Vehicle update(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public void delete(Long id){
        vehicleRepository.deleteById(id);
    }
}
