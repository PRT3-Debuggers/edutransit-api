package com.debuggers.controller;

import com.debuggers.domain.Parent;
import com.debuggers.service.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PostMapping
    public Parent createParent(@RequestBody Parent parent) {
        return parentService.save(parent);
    }

    @GetMapping("/{id}")
    public Parent getParentById(@PathVariable Long id) {
        return parentService.findById(id);
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.delete(id);
    }
}

