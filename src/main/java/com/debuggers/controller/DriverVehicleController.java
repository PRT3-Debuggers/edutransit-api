package com.debuggers.controller;


import com.debuggers.domain.DriverVehicle;
import com.debuggers.domain.DrivervehicleId;
import com.debuggers.service.impl.DriverVehicleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivervehicle")
public class DriverVehicleController {

    private DriverVehicleServiceImpl service;

    private DriverVehicleController(DriverVehicleServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create")
    public DriverVehicle create(@RequestBody DriverVehicle driverVehicle){
        return this.service.create(driverVehicle);
    }

    @GetMapping("/read{drivervehicleId}")
    public DriverVehicle read(@PathVariable DrivervehicleId drivervehicleId){
        return this.service.read(drivervehicleId);
    }

    @PutMapping("/update")
    public DriverVehicle update(@RequestBody DriverVehicle driverVehicle){
        return this.service.update(driverVehicle);
    }

    @DeleteMapping("/delete{drivervehicleId}")
    public void delete(@PathVariable DrivervehicleId drivervehicleId){
        this.service.delete(drivervehicleId);
    }

    @GetMapping("/getAll")
    public List<DriverVehicle> getAll(){
        return this.service.getAllDriverVehicles();
    }
}
