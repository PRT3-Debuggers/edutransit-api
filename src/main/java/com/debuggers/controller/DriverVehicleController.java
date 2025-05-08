package com.debuggers.controller;

import com.debuggers.domain.Drivervehicle;
import com.debuggers.service.DriverVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DriverVehicleController {
    private final DriverVehicleService driverVehicleService;

    public DriverVehicleController(DriverVehicleService driverVehicleService){
        this.driverVehicleService = driverVehicleService;
    }

    @PostMapping
    public ResponseEntity<Drivervehicle> createDriverVehicle(@RequestBody Drivervehicle drivervehicle){
        Drivervehicle newDriverVehicle = driverVehicleService.create(drivervehicle);
        if(newDriverVehicle == null){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(drivervehicle,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drivervehicle> getDriverVehicle(@PathVariable Long id){
        Drivervehicle drivervehicle = driverVehicleService.read(id);
        if(drivervehicle == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(drivervehicle,HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Drivervehicle>> readAllDriverVehicles(@PathVariable Long id){
        List<Drivervehicle> drivervehicles = driverVehicleService.readAll();
        if(drivervehicles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(drivervehicles,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drivervehicle> updateDriverVehicle(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverVehicle(@PathVariable Long id){
        Drivervehicle drivervehicle = driverVehicleService.read(id);
        if(drivervehicle == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            driverVehicleService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
