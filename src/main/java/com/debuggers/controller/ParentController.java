package com.debuggers.controller;

import com.debuggers.domain.Parent;
import com.debuggers.domain.User;
import com.debuggers.dto.CreateParentRequest;
import com.debuggers.dto.UpdateParentRequest;
import com.debuggers.service.impl.ParentServiceImpl;
import com.debuggers.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/parent")
public class ParentController {

    private final ParentServiceImpl parentService;
    private final UserServiceImpl userService;

    @Autowired
    public ParentController(ParentServiceImpl parentService, UserServiceImpl userService) {
        this.parentService = parentService;
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Parent> createParent(@RequestBody CreateParentRequest request) {
        // Create user from request data
        User user = new User.Builder()
                .setFirstName(request.getFirstName())
                .setLastName(request.getLastName())
                .setEmailAddress(request.getEmailAddress())
                .setPassword(request.getPassword())
                .build();

        // Create the user first
        User createdUser = userService.create(user);

        // Create a new parent with the created user
        Parent parent = new Parent.Builder()
                .setUser(createdUser)
                .build();

        Parent createdParent = parentService.create(parent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParent);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Parent> readParent(@PathVariable Long id) {
        return parentService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update")
    public ResponseEntity<Parent> updateParent(@RequestBody UpdateParentRequest request) {
        // First, get the existing parent
        Parent existingParent = parentService.read(request.getParentId())
                .orElseThrow(() -> new RuntimeException("Parent not found with ID: " + request.getParentId()));

        // Update the user information
        User user = existingParent.getUser();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmailAddress(request.getEmailAddress());
        user.setPassword(request.getPassword());

        // Update the user
        User updatedUser = userService.update(user);

        // Update the parent with the updated user
        Parent updatedParent = new Parent.Builder()
                .copy(existingParent)
                .setUser(updatedUser)
                .build();

        Parent updated = parentService.update(updatedParent);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteParent(@PathVariable Long id) {
        parentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Parent>> getAllParents() {
        Set<Parent> parents = parentService.getAllParent();
        return ResponseEntity.ok(parents);
    }
}
