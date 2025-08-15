package com.debuggers.service.impl;

import com.debuggers.domain.User;
import com.debuggers.repository.UserRepository;
import com.debuggers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*

     Author: Bonga Velem (220052379)

    */
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public Set<User> getAllUser() {
        return new HashSet<>(userRepo.findAll()); // ✅ valid use of JpaRepository
    }

    @Override
    public Optional<User> read(Long id) {
        return userRepo.findById(String.valueOf(id));
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(String.valueOf(id));
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAddressAndPassword(email, password);
    }
}
