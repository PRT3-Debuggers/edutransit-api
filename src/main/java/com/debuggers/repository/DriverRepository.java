package com.debuggers.repository;

import com.debuggers.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Set<Driver>getAllDriver();

    List<Driver> id(String id);
}
