package com.debuggers.service.impl;

import com.debuggers.domain.School;
import com.debuggers.repository.SchoolRepository;
import com.debuggers.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository schoolRepository;

    private SchoolService service;


    @Override
    public School read(Long id) {
        return schoolRepository.findById(id).orElse(null);
    }

    @Override
    public School create(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }


    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }
}
