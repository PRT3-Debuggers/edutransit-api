package com.debuggers.service.impl;

import com.debuggers.domain.Parent;
import com.debuggers.repository.ParentRepository;
import com.debuggers.service.ParentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    public ParentServiceImpl(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent save(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent findById(Long id) {
        return parentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Parent> findAll() {
        return parentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        parentRepository.deleteById(id);
    }
}
