package com.debuggers.controller;


import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.service.impl.DriverLanguageServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverlanguage")
public class DriverLanguageController {

    private DriverLanguageServiceImpl service;

    private DriverLanguageController(DriverLanguageServiceImpl service){
        this.service = service;
    }

    // POST MAPPING: SENDING/STORING INFORMATION
    @PostMapping("/create")
    public DriverLanguage create(@RequestBody DriverLanguage driverLanguage){
        return this.service.create(driverLanguage);
    }

    //GET MAPPING: PASSING THE PRIMARY KEY + RETURNING THE RESULT
    @GetMapping("/read{driverlanguageId}")
    public DriverLanguage read(@PathVariable DriverlanguageId driverlanguageId){
        return this.service.read(driverlanguageId);
    }

    // PUT MAPPING:
    @PutMapping("/update")
    public DriverLanguage update(@RequestBody DriverLanguage driverLanguage){
        return this.service.update(driverLanguage);
    }

    // DELETE MAPPING
    @DeleteMapping("/delete{driverlanguageId}")
    public void delete(@PathVariable DriverlanguageId driverlanguageId){
         this.service.delete(driverlanguageId);
    }

    @GetMapping("/getAll")
    public List<DriverLanguage> getAll(){
        return this.service.getAllDriverLanguages();
    }
}



