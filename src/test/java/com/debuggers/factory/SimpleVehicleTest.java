package com.debuggers.factory;

import com.debuggers.domain.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleVehicleTest {

  @Test
  void testVehicleCreation() {
    Vehicle vehicle = new Vehicle();
    assertNotNull(vehicle);
  }

  @Test
  void testVehicleBuilder() {
    Vehicle vehicle = new Vehicle.Builder()
        .setId(1L)
        .setVehicleModel("Tesla")
        .setVehicleType("Electric")
        .build();

    assertEquals(1L, vehicle.getId());
    assertEquals("Tesla", vehicle.getVehicleModel());
    assertEquals("Electric", vehicle.getVehicleType());
  }

  @Test
  void testVehicleSettersAndGetters() {
    Vehicle vehicle = new Vehicle();

    vehicle.setId(10L);
    vehicle.setVehicleModel("BMW");
    vehicle.setVehicleType("Sedan");

    assertEquals(10L, vehicle.getId());
    assertEquals("BMW", vehicle.getVehicleModel());
    assertEquals("Sedan", vehicle.getVehicleType());
  }

  @Test
  void testBuilderCopyMethod() {
    Vehicle original = new Vehicle.Builder()
        .setId(5L)
        .setVehicleModel("Mercedes")
        .setVehicleType("SUV")
        .build();

    Vehicle.Builder builder = new Vehicle.Builder();
    builder.copy(original);
    Vehicle copied = builder.build();

    assertEquals(original.getId(), copied.getId());
    assertEquals(original.getVehicleModel(), copied.getVehicleModel());
    assertEquals(original.getVehicleType(), copied.getVehicleType());
    assertNotSame(original, copied);
  }
}
