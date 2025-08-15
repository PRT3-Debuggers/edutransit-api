
package com.debuggers;

import com.debuggers.Domain.Vehicle;
import com.debuggers.Repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final VehicleRepository vehicleRepository;

    public DataInitializer(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public void run(String... args) {
        if (vehicleRepository.count() == 0) {
            for (int i = 1; i <= 200; i++) {
                vehicleRepository.save(new Vehicle("Vehicle Type " + i));
            }
        }
    }
}
