package com.debuggers.repository;

import com.debuggers.domain.DriverVehicle;
import com.debuggers.domain.DrivervehicleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface DriverVehicleRepository extends JpaRepository<DriverVehicle, DrivervehicleId> {
    List<DriverVehicle> getAllDriverVehicles();

    //  List<DriverVehicle> id(String id);
}
