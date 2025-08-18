package com.debuggers.service;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.domain.DriverschoolId;

import java.util.List;

public interface DriverLanguageService extends IService<DriverLanguage, DriverlanguageId>{
    List<DriverLanguage> getAllDriverLanguages();

}
