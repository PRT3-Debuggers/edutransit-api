package com.debuggers.controller;

import com.debuggers.domain.School;
import com.debuggers.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.save(school);
    }

    @GetMapping("/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.findById(id);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Long id) {
        schoolService.delete(id);
    }
}
