package com.debuggers.controller;

import com.debuggers.domain.User;
import com.debuggers.dto.LoginRequest;
import com.debuggers.factory.UserFactory;
import com.debuggers.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    // Just returns a sample user (not saved)
    @GetMapping("/sample")
    public User retrieveSampleUser() {
        User user = new User.Builder()
                .setId(UserFactory.createUserId())
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

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest loginDetails) {
        User user = userService.findByEmailAndPassword(
                loginDetails.getEmailAddress(),
                loginDetails.getPassword()
        );
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
    //
     @PostMapping("/update")
     public ResponseEntity<User> update(@RequestBody User user) {
     return ResponseEntity.ok(userService.update(user));
     }
    //
     @GetMapping("/all")
     public ResponseEntity<Set<User>> getAll() {
     return ResponseEntity.ok(userService.getAllUser());
     }
    //
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<Void> delete(@PathVariable Long id) {
     userService.delete(id);
     return ResponseEntity.noContent().build();
     }
}

// @PostMapping("/create")
// public ResponseEntity<User> create(@RequestBody User user) {
// User newUser = userService.create(user);
// System.out.println("Print new data: " + newUser);
// return ResponseEntity.ok(newUser);
// }

// @PostMapping("/create")
// public ResponseEntity<User> create(@ResponseBody User user){
// User newUser = userService.create(user);
// return ResponseEntity.ok(newUser);
// }

// @PostMapping("/create")
// public ResponseEntity<User> create(@RequestBody User user) {
// return ResponseEntity.ok(userService.create(user));
// }
//