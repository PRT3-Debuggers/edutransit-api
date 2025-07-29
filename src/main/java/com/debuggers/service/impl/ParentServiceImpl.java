package com.debuggers.service.impl;

import com.debuggers.domain.Parent;
import com.debuggers.repository.ParentRepository;
import com.debuggers.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepo;


    @Autowired
    public ParentServiceImpl(ParentRepository parentRepo){
        this.parentRepo = parentRepo;
    }

    @Override
    public Parent create(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    public Optional<Parent> read(Long id) {
        return parentRepo.findById(String.valueOf(id));
    }

    @Override
    public Parent update(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    public void delete(Long id) {
         parentRepo.deleteById(String.valueOf(id));
    }

    @Override
    public Set<Parent> getAllParent() {
        return parentRepo.getAllParent();
    }




}
