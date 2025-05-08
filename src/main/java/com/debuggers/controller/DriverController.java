package com.debuggers.controller;

import com.debuggers.domain.Driver;
import com.debuggers.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver){
        Driver newDriver = driverService.create(driver);
        if (newDriver == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
                return new ResponseEntity<>(newDriver,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriver(@PathVariable Long id){
        Driver driver = driverService.read(id);
        if(driver == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(driver,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers(){
        List<Driver> drivers = driverService.readAll();
        if(drivers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(drivers,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id){
        Driver driver = driverService.read(id);
        if(driver == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            driverService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
