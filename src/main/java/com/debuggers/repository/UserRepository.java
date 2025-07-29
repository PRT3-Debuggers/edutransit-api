package com.debuggers.repository;

import com.debuggers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
   // Set<User>getAllUser();
}
