package com.debuggers.controller;


import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;
import com.debuggers.service.impl.DriverSchoolServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverschool")
public class DriverSchoolController {

    private DriverSchoolServiceImpl service;

    public DriverSchoolController(DriverSchoolServiceImpl service ){
        this.service = service;
    }

    // STORING/SENDING INFORMATION
    @PostMapping("/create")
    public DriverSchool create(@RequestBody DriverSchool driverSchool){
        return service.create(driverSchool);
    }

    // PASSING PRIMARY KEY + RETURNING THE RESULT
    @GetMapping("/read/{driverschoolId}")
    public DriverSchool read(@PathVariable DriverschoolId driverschoolId){
        return service.read(driverschoolId);
    }

    // TAKE OBJECT
    @PutMapping("/update")
    public DriverSchool update(@RequestBody DriverSchool driverSchool){
        return service.update(driverSchool);
    }

    @DeleteMapping("/delete/{d" +
            "riverschoolId}")
    public void delete(@PathVariable DriverschoolId driverschoolId){
         this.service.delete(driverschoolId);
    }

    @GetMapping("/getAll")
    public List<DriverSchool> getAll(){
        return service.getAllDriverSchools();
    }
}
