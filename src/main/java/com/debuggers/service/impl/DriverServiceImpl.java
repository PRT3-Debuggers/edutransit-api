package com.debuggers.service.impl;

import com.debuggers.domain.Driver;
import com.debuggers.repository.DriverRepository;
import com.debuggers.service.DriverService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/*

     Author: Bonga Velem (220052379)

    */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {


    private final DriverRepository driverRepo;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    @Transactional
    public Driver create(Driver driver) {
        return driverRepo.save(driver);
    }

    @Override
    @Transactional
    public Optional<Driver> read(Long id) {
        return driverRepo.findById(id);
    }


    @Override
    @Transactional
    public Driver update(Driver driver) {
        if (driverRepo.existsById(driver.getId())) {
            return driverRepo.save(driver);
        }
        return null;

    }

    @Override
    @Transactional
    public void delete(Long id) {
        driverRepo.deleteById(Long.valueOf(id));

    }

    @Override
    @Transactional
    public List<Driver> findAll() {
        return driverRepo.findAll();
    }


}
