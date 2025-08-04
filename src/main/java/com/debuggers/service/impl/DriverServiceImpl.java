package com.debuggers.service.impl;

import com.debuggers.domain.Driver;
import com.debuggers.repository.DriverRepository;
import com.debuggers.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*

     Author: Bonga Velem (220052379)

    */
@Service
public class DriverServiceImpl implements DriverService {


    private final DriverRepository driverRepo;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public Driver create(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    public Optional<Driver> read(Long id) {
        return driverRepo.findById(id);
    }

//    @Override
//    public Optional<Driver> read(Long id) {
//        driverRepo.findById(id);
//        return null;
//    }


    @Override
    public Driver update(Driver driver) {
        if (driverRepo.existsById(driver.getId())) {
            return driverRepo.save(driver);
        }
        return null;

    }

    @Override
    public void delete(Long id) {
        driverRepo.deleteById(Long.valueOf(id));

    }

    @Override
    public List<Driver> findAll() {
        return driverRepo.findAll();
    }


}
