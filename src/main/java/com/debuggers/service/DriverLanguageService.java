package com.debuggers.service;

import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;

import java.util.List;

public interface DriverLanguageService extends Service<DriverLanguage, DriverlanguageId>{
    List<DriverLanguage> getAllDriverLanguages();

}
