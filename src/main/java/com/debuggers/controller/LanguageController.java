package com.debuggers.controller;

import com.debuggers.domain.Language;
import com.debuggers.service.LanguageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class LanguageController {

    private final LanguageService service;

    public LanguageController(LanguageService service){
        this.service = service;
    }

    @PostMapping("/language/create")
    public Language create(@RequestBody Language language){
        return service.create(language);
    }

    @GetMapping("/read{id}")
    public Language read(@PathVariable Long id){
        return service.read(id);
    }

    @PutMapping("/update")
    public Language update(@RequestBody Language language){
        return service.update(language);
    }

    @DeleteMapping("/delete{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
