package com.debuggers.repository;

import com.debuggers.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverRepository extends JpaRepository<Driver,Long> {
}
