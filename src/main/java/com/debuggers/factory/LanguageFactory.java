package com.debuggers.factory;


import com.debuggers.domain.Language;
import com.debuggers.util.Helper;

public class LanguageFactory {
    public static Language createLanguage(Long id, String languageName, String code){
        if (Helper.IsEmptyOrNullString(String.valueOf(id))
        || Helper.IsEmptyOrNullString(languageName)
        || Helper.IsEmptyOrNullString(code)) {
            return null;
        }
            return new Language.Builder()
                    .setId(id)
                    .setLanguageName(languageName)
                    .setCode(code)
                    .build();
    }
}
