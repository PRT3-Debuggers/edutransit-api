package com.debuggers.service;

import com.debuggers.domain.Driver;
import com.debuggers.repository.IDriverRepository;

import java.util.List;

public class DriverService {
    private final IDriverRepository driverRepository;

    public DriverService(IDriverRepository driverRepository){
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver read(Long id){
        return driverRepository.findById(id).orElse(null);
    }

    public List<Driver> readAll(){
        return driverRepository.findAll();
    }

    public Driver update(Driver driver){
        return driverRepository.save(driver);
    }

    public void delete(Long id){
        driverRepository.deleteById(id);
    }
}
