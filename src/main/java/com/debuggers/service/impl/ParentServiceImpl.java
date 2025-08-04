package com.debuggers.service.impl;
/*

     Author: Bonga Velem (220052379)

    */
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
        return parentRepo.findById(id);
    }

    @Override
    public Parent update(Parent parent) {
        return parentRepo.save(parent);
    }

    @Override
    public void delete(Long id) {
         parentRepo.deleteById(id);
    }

    public Set<Parent> getAllParent() {
        return Set.copyOf(parentRepo.findAll());
    }

//    @Override
//    public Set<Parent> getAllParent() {
//        return parentRepo.getAllParent();
//    }




}
