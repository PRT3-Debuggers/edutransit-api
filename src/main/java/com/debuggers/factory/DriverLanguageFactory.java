package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.DriverLanguage;
import com.debuggers.domain.DriverlanguageId;
import com.debuggers.domain.Language;
import com.debuggers.util.Helper;


public class DriverLanguageFactory {
    public static DriverLanguage createDriverLanguage(
            DriverlanguageId id, Driver driver, Language language
            ){
        if (
                Helper.IsEmptyOrNullString(String.valueOf(id))||
                        Helper.IsEmptyOrNullString(String.valueOf(driver))||
                        Helper.IsEmptyOrNullString(String.valueOf(language))
        ){
            return null;
        }
        return new DriverLanguage.Builder()
                .setId(id)
                .setDriver(driver)
                .setLanguage(language)
                .build();
    }
}
