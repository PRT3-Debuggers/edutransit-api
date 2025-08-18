package com.debuggers.repository;

import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverSchoolRepository extends JpaRepository<DriverSchool, DriverschoolId> {
    List<DriverSchool> getAllDriverSchools();

//    List<DriverSchool> id(String id);
}
