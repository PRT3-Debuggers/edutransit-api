package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.Driverlanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.domain.Language;

public class DriverLanguageFactory {
    public static Driverlanguage createDriverLanguage(
            DriverlanguageId id,
            Driver driver,
            Language language
    ){
        if(
            id == null  ||  driver == null   ||  language == null
        ) {
            return null;
        }
        return new Driverlanguage.Builder()
                .setId(id)
                .setDriver(driver)
                .setLanguage(language)
                .build();
        }
    }