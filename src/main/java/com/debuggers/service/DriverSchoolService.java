package com.debuggers.service;

import com.debuggers.domain.Driverschool;
import com.debuggers.repository.IDriverSchoolRepository;

import java.util.List;

public class DriverSchoolService {
    private final IDriverSchoolRepository driverSchoolRepository;

    public DriverSchoolService(IDriverSchoolRepository driverSchoolRepository){
        this.driverSchoolRepository = driverSchoolRepository;
    }

    public Driverschool create(Driverschool driverschool){
        return driverSchoolRepository.save(driverschool);
    }

    public Driverschool read(Long id){
        return driverSchoolRepository.findById(id).orElse(null);
    }

    public List<Driverschool> readAll(){
        return driverSchoolRepository.findAll();
    }

    public Driverschool update(Driverschool driverschool){
        return driverSchoolRepository.save(driverschool);
    }

    public void delete(Long id){
        driverSchoolRepository.deleteById(id);
    }
}
