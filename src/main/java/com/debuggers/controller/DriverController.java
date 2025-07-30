package com.debuggers.controller;

import com.debuggers.domain.Driver;
import com.debuggers.factory.DriverFactory;
import com.debuggers.service.impl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/driver")
public class DriverController {

    private final DriverServiceImpl driverService;

    @Autowired
    public DriverController(DriverServiceImpl driverService){
        this.driverService = driverService;
    }

    @PostMapping("api/driver/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Driver createDriver(@RequestBody Driver driver){
        Driver driverLewis = DriverFactory.createDriver( "None", "5", "3");
        return driverService.create(driverLewis);

    }

    @GetMapping("read")
    public Optional<Driver> readDriver(@RequestBody Long id){
        return driverService.read(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        Driver updated = driverService.update(driver);

        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.findAll();
        return ResponseEntity.ok(drivers);
    }




}
