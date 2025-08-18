package com.debuggers.service.impl;

import com.debuggers.domain.Language;
import com.debuggers.repository.LanguageRepository;
import com.debuggers.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    @Override
    public Language create(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public Language update(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Language read(Long id) {
        return languageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }
}
