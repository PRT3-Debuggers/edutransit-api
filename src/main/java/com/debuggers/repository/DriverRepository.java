package com.debuggers.repository;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    // Use the standard findAll() method from JpaRepository instead
    // Set<Driver>getAllDriver();

    List<Driver> id(Long id);
}
