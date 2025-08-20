package com.debuggers.controller;

import com.debuggers.domain.School;
import com.debuggers.domain.Vehicle;
import com.debuggers.service.impl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
@CrossOrigin(origins = "http://localhost:5173")
public class VehicleController {

    private final VehicleServiceImpl vehicleService;

    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/createVehicle")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle){
        return vehicleService.create(vehicle);

    }

    @GetMapping("/{id}")
    public Vehicle read(@PathVariable Long id){
        return vehicleService.read(id);
    }

    @PutMapping("/update")
    public Vehicle update(@RequestBody Vehicle vehicle){
        return vehicleService.update(vehicle);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehicleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(allVehicles);
    }
}
