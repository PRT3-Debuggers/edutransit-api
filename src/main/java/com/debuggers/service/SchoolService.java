package com.debuggers.service;

import com.debuggers.domain.School;

import java.util.List;

public interface SchoolService extends Service<School, Long> {
    List<School> getAllSchools();
}
