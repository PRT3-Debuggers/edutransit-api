package com.debuggers.service;

import com.debuggers.domain.School;

public interface SchoolService extends Service<School, Long>{

    School read(Long id);
}
