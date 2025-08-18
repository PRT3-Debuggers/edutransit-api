package com.debuggers.service;

import com.debuggers.domain.Language;

import java.util.List;

public interface LanguageService extends Service<Language, Long> {
    Language read(Long id);

    List<Language> findAllLanguages();
}
