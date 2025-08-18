package com.debuggers.service.impl;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.repository.DriverLanguageRepository;
import com.debuggers.service.DriverLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverLanguageServiceImpl implements DriverLanguageService {

    @Autowired
    private static DriverLanguageService service;

    private DriverLanguageRepository repository;


    @Override
    public List<DriverLanguage> getAllDriverSchools() {
        return this.repository.findAll();
    }

    @Override
    public DriverLanguage create(DriverLanguage driverLanguage) {
        return this.repository.save(driverLanguage);
    }

    @Override
    public DriverLanguage read(DriverlanguageId id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public DriverLanguage update(DriverLanguage driverLanguage) {
        return this.repository.save(driverLanguage);
    }

    @Override
    public void delete(DriverlanguageId id) {
        this.repository.deleteById(id);
    }
}
