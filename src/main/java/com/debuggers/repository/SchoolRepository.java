package com.debuggers.repository;

import com.debuggers.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {

    List<School> getAllSchools();
}
