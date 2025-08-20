package com.debuggers.controller;

import com.debuggers.domain.School;
import com.debuggers.service.impl.SchoolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
@CrossOrigin(origins = "http://localhost:5173")
public class SchoolController {

    private final SchoolServiceImpl schoolService;

    @Autowired
    public SchoolController(SchoolServiceImpl schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/createSchool")
    public School createSchool(@RequestBody School school) {
        return schoolService.create(school);
    }

    @GetMapping("/{id}")
    public School read(@PathVariable Long id) {
        return schoolService.read(id);
    }

    @PutMapping("/update")
    public School update(@RequestBody School school) {
        return schoolService.update(school);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        schoolService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        List<School> allSchools = schoolService.getAllSchools();
        return ResponseEntity.ok(allSchools);
    }
}
