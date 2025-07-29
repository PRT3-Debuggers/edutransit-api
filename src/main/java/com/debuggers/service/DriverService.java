package com.debuggers.service;

import com.debuggers.domain.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService extends Service<Driver, Long> {



    Optional<Driver> read(Long id);





    List<Driver> findAll();
}
