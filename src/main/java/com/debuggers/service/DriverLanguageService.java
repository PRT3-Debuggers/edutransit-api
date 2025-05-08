package com.debuggers.service;

import com.debuggers.domain.Driverlanguage;
import com.debuggers.repository.IDriverLanguageRepository;

import java.util.List;

public class DriverLanguageService {
    private final IDriverLanguageRepository driverLanguageRepository;

    public DriverLanguageService(IDriverLanguageRepository driverLanguageRepository){
        this.driverLanguageRepository = driverLanguageRepository;
    }

    public Driverlanguage create(Driverlanguage driverlanguage){
        return driverLanguageRepository.save(driverlanguage);
    }

    public Driverlanguage read(Long id){
        return driverLanguageRepository.findById(id).orElse(null);
    }

    public List<Driverlanguage> readAll(){
        return driverLanguageRepository.findAll();
    }

    public Driverlanguage update(Driverlanguage driverlanguage){
        return driverLanguageRepository.save(driverlanguage);
    }

    public void delete(Long id){
        driverLanguageRepository.deleteById(id);
    }
}
