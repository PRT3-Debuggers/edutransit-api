package com.debuggers.service;

import com.debuggers.domain.User;

import java.util.Optional;
import java.util.Set;

public interface UserService extends Service<User, Long>{
    Set<User> getAllUser();
    Optional<User> read(Long id);
}
