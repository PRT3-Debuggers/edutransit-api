package com.debuggers.service;

import com.debuggers.domain.User;
import com.debuggers.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User read(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
