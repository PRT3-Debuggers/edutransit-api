package com.debuggers.service;

import com.debuggers.domain.Parent;

import java.util.List;

public interface ParentService {
    Parent save(Parent parent);
    Parent findById(Long id);
    List<Parent> findAll();
    void delete(Long id);
}
