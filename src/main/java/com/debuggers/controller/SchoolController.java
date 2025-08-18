package com.debuggers.controller;


import com.debuggers.domain.School;
import com.debuggers.service.impl.SchoolServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/school")
public class SchoolController {

    private SchoolServiceImpl service;

    private SchoolController(SchoolServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create")
    public School create(@RequestBody School school){
        return service.create(school);
    }

    @GetMapping("/read{id}")
    public School read(@PathVariable Long id){
        return service.read(id);
    }

    @PostMapping("/update")
    public School update(@RequestBody School school){
        return service.update(school);
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public List<School> getAll(){
        return service.getAllSchools();
    }
}
