package com.debuggers.service;

import com.debuggers.domain.School;

import java.util.List;

public interface SchoolService {
    School save(School school);
    School findById(Long id);
    List<School> findAll();
    void delete(Long id);
}
