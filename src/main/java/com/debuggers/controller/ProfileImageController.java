package com.debuggers.controller;

import com.debuggers.domain.ProfileImage;
import com.debuggers.service.ProfileImageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profileImages")
public class ProfileImageController {

    private ProfileImageService service;

    @PostMapping
    public ProfileImage create(@RequestBody ProfileImage profileImage) {
        return service.save(profileImage);
    }

    @GetMapping("/{id}")
    public ProfileImage getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<ProfileImage> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
