package com.debuggers.repository;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    // Use the standard findAll() method from JpaRepository instead
    // Set<Parent>getAllParent();

    List<Parent> id(Long id);


}
