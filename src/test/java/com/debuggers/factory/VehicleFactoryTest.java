package com.debuggers.factory;

import com.debuggers.domain.Vehicle;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleFactoryTest {

    @Test
    @Order(1)
    void testCreateVehicleWithId() {
        Vehicle vehicle = VehicleFactory.createVehicle(4L, "Ferrari", "Gran Touring");

        assertNotNull(vehicle);
        assertEquals(4L, vehicle.getId());
        assertEquals("Ferrari", vehicle.getVehicleModel());
        assertEquals("Gran Touring", vehicle.getVehicleType());
    }

    @Test
    @Order(2)
    void testCreateVehicleWithoutId() {
        Vehicle vehicle = VehicleFactory.createVehicle("BMW", "Sedan");

        assertNotNull(vehicle);
        assertNull(vehicle.getId()); // ID will be null until persisted
        assertEquals("BMW", vehicle.getVehicleModel());
        assertEquals("Sedan", vehicle.getVehicleType());
    }

    @Test
    @Order(3)
    void testCreateVehicleWithNullValues() {
        Vehicle vehicle = VehicleFactory.createVehicle(1L, null, "Sports");
        assertNull(vehicle);

        vehicle = VehicleFactory.createVehicle(1L, "Ferrari", null);
        assertNull(vehicle);

        vehicle = VehicleFactory.createVehicle(1L, "", "Sports");
        assertNull(vehicle);
    }

    @Test
    @Order(4)
    void testCopyVehicle() {
        Vehicle originalVehicle = VehicleFactory.createVehicle(5L, "Mercedes", "SUV");
        assertNotNull(originalVehicle);

        Vehicle copiedVehicle = VehicleFactory.copyVehicle(originalVehicle);
        assertNotNull(copiedVehicle);

        // Check that all fields are copied
        assertEquals(originalVehicle.getId(), copiedVehicle.getId());
        assertEquals(originalVehicle.getVehicleModel(), copiedVehicle.getVehicleModel());
        assertEquals(originalVehicle.getVehicleType(), copiedVehicle.getVehicleType());

        // Verify they are different objects
        assertNotSame(originalVehicle, copiedVehicle);
    }

    @Test
    @Order(5)
    void testCopyVehicleWithNull() {
        Vehicle copiedVehicle = VehicleFactory.copyVehicle(null);
        assertNull(copiedVehicle);
    }

    @Test
    @Order(6)
    void testCreateVehicleId() {
        Long vehicleId = VehicleFactory.createVehicleId();
        assertNotNull(vehicleId);
        assertTrue(vehicleId > 0);
    }

    @Test
    @Order(7)
    void testBuilderCopyMethod() {
        Vehicle originalVehicle = VehicleFactory.createVehicle(6L, "Audi", "Hatchback");
        assertNotNull(originalVehicle);

        // Test the Builder's copy method directly
        Vehicle.Builder builder = new Vehicle.Builder();
        builder.copy(originalVehicle);
        Vehicle copiedVehicle = builder.build();

        assertNotNull(copiedVehicle);
        assertEquals(originalVehicle.getId(), copiedVehicle.getId());
        assertEquals(originalVehicle.getVehicleModel(), copiedVehicle.getVehicleModel());
        assertEquals(originalVehicle.getVehicleType(), copiedVehicle.getVehicleType());
    }

    @Test
    @Order(8)
    void testVehicleSettersAndGetters() {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(10L);
        vehicle.setVehicleModel("Tesla");
        vehicle.setVehicleType("Electric");

        assertEquals(10L, vehicle.getId());
        assertEquals("Tesla", vehicle.getVehicleModel());
        assertEquals("Electric", vehicle.getVehicleType());
    }

    @Test
    @Order(9)
    void testVehicleBuilderPattern() {
        Vehicle vehicle = new Vehicle.Builder()
                .setId(15L)
                .setVehicleModel("Porsche")
                .setVehicleType("Sports Car")
                .build();

        assertEquals(15L, vehicle.getId());
        assertEquals("Porsche", vehicle.getVehicleModel());
        assertEquals("Sports Car", vehicle.getVehicleType());
    }
}