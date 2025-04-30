package com.debuggers.repository;

import com.debuggers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User create();
    public User read(Long id);
    public User readAll();
    public void delete(User user);
    public User update(User user);
}
