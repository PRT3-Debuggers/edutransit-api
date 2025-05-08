package com.debuggers.service;

import com.debuggers.domain.Language;

import java.util.List;

public interface LanguageService {
    Language save(Language language);
    Language findById(Long id);
    List<Language> findAll();
    void delete(Long id);
}
