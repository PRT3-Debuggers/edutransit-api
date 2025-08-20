package com.debuggers.repository;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverLanguageRepository extends JpaRepository<DriverLanguage, DriverlanguageId> {
    // Use JpaRepository#findAll() instead of a non-derived method signature
}
