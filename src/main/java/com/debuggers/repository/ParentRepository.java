package com.debuggers.repository;

import com.debuggers.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ParentRepository extends JpaRepository<Parent, String> {
    Set<Parent>getAllParent();

    List<Parent> id(String id);
}
