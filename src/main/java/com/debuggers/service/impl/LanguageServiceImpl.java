package com.debuggers.service.impl;

import com.debuggers.domain.Language;
import com.debuggers.repository.LanguageRepository;
import com.debuggers.service.LanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language save(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language findById(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);

    }
}
