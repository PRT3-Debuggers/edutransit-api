package com.debuggers.service.impl;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.repository.DriverLanguageRepository;
import com.debuggers.service.DriverLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverLanguageServiceImpl implements DriverLanguageService {

    @Autowired
    private DriverLanguageRepository repository;

    @Override
    public DriverLanguage create(DriverLanguage driverLanguage) {
        return this.repository.save(driverLanguage);
    }

    public Optional<DriverLanguage> read(DriverlanguageId driverlanguageId){
        return this.repository.findById(driverlanguageId);
    }

    @Override
    public DriverLanguage update(DriverLanguage driverLanguage) {
        return this.repository.save(driverLanguage);
    }

    @Override
    public void delete(DriverlanguageId id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<DriverLanguage> getAllDriverLanguages() {
        return this.repository.findAll();
    }
}
