package com.debuggers.service.impl;

import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;
import com.debuggers.repository.DriverSchoolRepository;
import com.debuggers.service.DriverSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverSchoolServiceImpl implements DriverSchoolService {

    private final DriverSchoolRepository repository;

    @Autowired
    public DriverSchoolServiceImpl(DriverSchoolRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DriverSchool> getAllDriverSchools() {
        return this.repository.findAll();
    }

    @Override
    public DriverSchool create(DriverSchool driverSchool) {
        return this.repository.save(driverSchool);
    }

    @Override
    public DriverSchool read(DriverschoolId id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public DriverSchool update(DriverSchool driverSchool) {
        return this.repository.save(driverSchool);
    }

    @Override
    public void delete(DriverschoolId id) {
        this.repository.deleteById(id);
    }
}
