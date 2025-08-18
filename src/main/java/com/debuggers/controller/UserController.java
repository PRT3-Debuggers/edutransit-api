package com.debuggers.controller;
/* User.java

     User Controller class

     Author: Bonga Velem (220052379)

     */

import com.debuggers.domain.User;
import com.debuggers.domain.Parent;
import com.debuggers.domain.Driver;
import com.debuggers.dto.LoginRequest;
import com.debuggers.dto.SignUpWithRoleRequest;
import com.debuggers.factory.UserFactory;
import com.debuggers.service.impl.UserServiceImpl;
import com.debuggers.service.impl.ParentServiceImpl;
import com.debuggers.service.impl.DriverServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ParentServiceImpl parentService;

    @Autowired
    private DriverServiceImpl driverService;

    // Just returns a sample user (not saved)
    @GetMapping("/sample")
    public User retrieveSampleUser() {
        User user = new User.Builder()
                .setFirstName("Devin")
                .setLastName("Booker")
                .setEmailAddress("booker@gmail.com")
                .setPassword("Devin@1")
                .build();
        return user;

    }

    // Saves user
    @PostMapping("/create")
    public User createUser(@RequestBody final User user) {
        log.info("User received: " + user.toString());
        System.out.println(user);
        return userService.create(user);

    }

    // Saves user with role-based entity creation
    @PostMapping("/signup")
    public User signUp(@RequestBody final SignUpWithRoleRequest signUpRequest) {
        User user = new User.Builder()
                .setId(UserFactory.createUserId())
                .setFirstName(signUpRequest.getFirstName())
                .setLastName(signUpRequest.getLastName())
                .setEmailAddress(signUpRequest.getEmailAddress())
                .setPassword(signUpRequest.getPassword())
                .build();

        log.info("User received: " + user.toString());
        System.out.println(user);

        User createdUser = userService.create(user);

        if (Objects.equals(signUpRequest.getRole(), "Parent")) {
            parentService.create(new Parent.Builder()
                    .setUser(createdUser)
                    .build());
        } else if (Objects.equals(signUpRequest.getRole(), "Driver")) {
            driverService.create(new Driver.Builder()
                    .setUser(createdUser)
                    .build());
        }

        return createdUser; // Return the created user, not create it again
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginDetails) {
        User user = userService.findByEmailAndPassword(
                loginDetails.getEmailAddress(),
                loginDetails.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).build(); // not found?
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<User> read(@PathVariable Long id) {
        ResponseEntity<User> userResponseEntity = userService.read(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        return userResponseEntity;
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @GetMapping("/all")
    public ResponseEntity<Set<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
