package com.debuggers.controller;

import com.debuggers.domain.Language;
import com.debuggers.service.LanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.save(language);
    }

    @GetMapping("/{id}")
    public Language getLanguageById(@PathVariable Long id) {
        return languageService.findById(id);
    }

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteLanguage(@PathVariable Long id) {
        languageService.delete(id);
    }
}
