package com.debuggers.service;

import com.debuggers.domain.DriverSchool;
import com.debuggers.domain.DriverschoolId;

import java.util.List;


public interface DriverSchoolService extends IService<DriverSchool, DriverschoolId>{

//    CUSTOM FUNCTIONALITY:

    List<DriverSchool> getAllDriverSchools();
}
