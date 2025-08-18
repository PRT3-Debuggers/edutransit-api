package com.debuggers.service.impl;

import com.debuggers.domain.User;
import com.debuggers.repository.UserRepository;
import com.debuggers.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*

     Author: Bonga Velem (220052379)

    */
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Set<User> getAllUser() {
        return new HashSet<>(userRepo.findAll());
    }

    @Override
    @Transactional
    public Optional<User> read(Long id) {
        return userRepo.findById(id);
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAddressAndPassword(email, password);
    }
}
