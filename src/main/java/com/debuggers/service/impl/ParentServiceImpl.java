package com.debuggers.service.impl;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Parent;
import com.debuggers.repository.ParentRepository;
import com.debuggers.service.ParentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepo;


    @Autowired
    public ParentServiceImpl(ParentRepository parentRepo){
        this.parentRepo = parentRepo;
    }

    @Override
    @Transactional
    public Parent create(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    @Transactional
    public Optional<Parent> read(Long id) {
        return parentRepo.findById(id);
    }

    @Override
    @Transactional
    public Parent update(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    @Transactional
    public void delete(Long id) {
         parentRepo.deleteById(id);
    }

    @Transactional
    public Set<Parent> getAllParent() {
        return Set.copyOf(parentRepo.findAll());
    }






}
