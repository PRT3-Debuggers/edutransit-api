package com.debuggers.factory;

import com.debuggers.domain.Language;

public class LanguageFactory {
    public static Language createLanguage(Long id, String languageName, String code){
        if (id == null || languageName == null || languageName.isEmpty() || code == null || code.isEmpty()){
            return null;
        }


        return new Language.Builder()
                .setId(id)
                .setLanguageName(languageName)
                .build();
    }
}
