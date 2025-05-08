package com.debuggers.controller;

import com.debuggers.domain.Driverlanguage;
import com.debuggers.service.DriverLanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverLanguages")
public class DriverLanguageController {
     private final DriverLanguageService driverLanguageService;

     public DriverLanguageController(DriverLanguageService driverLanguageService){
         this.driverLanguageService = driverLanguageService;
     }
     @PostMapping
    public ResponseEntity<Driverlanguage> createDriverLanguage(@RequestBody Driverlanguage driverlanguage){
         Driverlanguage newDriverlanguage = driverLanguageService.create(driverlanguage);
         if(newDriverlanguage == null){
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }
            return new ResponseEntity<>(driverlanguage,HttpStatus.CREATED);
     }

     @GetMapping("/{id}")
    public ResponseEntity<Driverlanguage> getDriverLanguage(@PathVariable Long id){
         Driverlanguage driverlanguage = driverLanguageService.read(id);
         if(driverlanguage == null){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
            return new ResponseEntity<>(driverlanguage,HttpStatus.OK);
     }

     @GetMapping
    public ResponseEntity<List<Driverlanguage>> readAllDriverLanguages(){
         List<Driverlanguage> driverlanguages = driverLanguageService.readAll();
         if(driverlanguages.isEmpty()){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
            return new ResponseEntity<>(driverlanguages,HttpStatus.OK);
     }

     @PutMapping("/{id}")
    public ResponseEntity<Driverlanguage> updateDriverLanguage(@PathVariable Long id){
         return new ResponseEntity<>(HttpStatus.OK);
     }

     @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverLanguage(@PathVariable Long id){
         Driverlanguage driverlanguage = driverLanguageService.read(id);
         if(driverlanguage == null){
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
            driverLanguageService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }

}
