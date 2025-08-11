package com.debuggers.repository;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverLanguageRepository extends JpaRepository<DriverLanguage, DriverlanguageId> {
    List<DriverLanguage> getAllDriverLanguages();

    //  List<DriverLanguage> id(String id);
}
