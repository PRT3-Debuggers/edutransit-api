package com.debuggers.controller;

import com.debuggers.domain.Driverschool;
import com.debuggers.service.DriverSchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverSchools")
public class DriverSchoolController {
    private final DriverSchoolService driverSchoolService;

    public DriverSchoolController(DriverSchoolService driverSchoolService){
        this.driverSchoolService = driverSchoolService;
    }

    @PostMapping
    public ResponseEntity<Driverschool> createDriverSchool(@RequestBody Driverschool driverschool){
        Driverschool newDriverSchool = driverSchoolService.create(driverschool);
        if(newDriverSchool == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(driverschool,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driverschool> getDriverSchool(@PathVariable Long id){
        Driverschool driverschool = driverSchoolService.read(id);
        if(driverschool == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(driverschool,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Driverschool>> getAllDriverSchools(){
        List<Driverschool> driverschools = driverSchoolService.readAll();
        if(driverschools.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            return new ResponseEntity<>(driverschools,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driverschool> updateDriverSchool(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverSchool(@PathVariable Long id){
        Driverschool driverschool = driverSchoolService.read(id);
        if(driverschool == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
            driverSchoolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
