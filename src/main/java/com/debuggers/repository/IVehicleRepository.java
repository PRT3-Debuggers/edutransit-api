package com.debuggers.repository;

import com.debuggers.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleRepository extends JpaRepository<Vehicle,Long> {
}
