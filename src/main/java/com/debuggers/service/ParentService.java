package com.debuggers.service;

import com.debuggers.domain.Parent;

import java.util.Optional;
import java.util.Set;

public interface ParentService extends Service<Parent, Long>{


    Set<Parent> getAllParent();
    Optional<Parent> read(Long id);
}
