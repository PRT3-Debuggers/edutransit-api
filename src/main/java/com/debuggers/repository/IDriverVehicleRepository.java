package com.debuggers.repository;

import com.debuggers.domain.Drivervehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDriverVehicleRepository extends JpaRepository<Drivervehicle,Long> {
}
