package com.debuggers.service;

import com.debuggers.domain.Drivervehicle;
import com.debuggers.repository.IDriverVehicleRepository;

import java.util.List;

public class DriverVehicleService {
    private final IDriverVehicleRepository driverVehicleRepository;

    public DriverVehicleService(IDriverVehicleRepository driverVehicleRepository){
        this.driverVehicleRepository = driverVehicleRepository;
    }

    public Drivervehicle create(Drivervehicle drivervehicle){
        return driverVehicleRepository.save(drivervehicle);
    }

    public Drivervehicle read(Long id){
        return driverVehicleRepository.findById(id).orElse(null);
    }

    public List<Drivervehicle> readAll(){
        return driverVehicleRepository.findAll();
    }

    public Drivervehicle update(Drivervehicle drivervehicle){
        return driverVehicleRepository.save(drivervehicle);
    }

    public void delete(Long id){
        driverVehicleRepository.deleteById(id);
    }
}
