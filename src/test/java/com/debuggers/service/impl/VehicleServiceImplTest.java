package com.debuggers.service.impl;

import com.debuggers.domain.Vehicle;
import com.debuggers.factory.VehicleFactory;
import com.debuggers.repository.VehicleRepository;
import com.debuggers.service.impl.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleServiceImplTest {

  @Mock
  private VehicleRepository vehicleRepository;

  @InjectMocks
  private VehicleServiceImpl vehicleService;

  private Vehicle testVehicle1;
  private Vehicle testVehicle2;
  private Vehicle testVehicle3;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    // Create test vehicles
    testVehicle1 = VehicleFactory.createVehicle(1L, "Toyota Camry", "Sedan");
    testVehicle2 = VehicleFactory.createVehicle(2L, "Honda CR-V", "SUV");
    testVehicle3 = VehicleFactory.createVehicle(3L, "Ford F-150", "Truck");
  }

  @Test
  @Order(1)
  void testCreateVehicle() {
    // Arrange
    Vehicle newVehicle = VehicleFactory.createVehicle(4L, "Tesla Model 3", "Electric");
    when(vehicleRepository.save(any(Vehicle.class))).thenReturn(newVehicle);

    // Act
    Vehicle createdVehicle = vehicleService.create(newVehicle);

    // Assert
    assertNotNull(createdVehicle, "Created vehicle should not be null");
    assertEquals(4L, createdVehicle.getId(), "Vehicle ID should match");
    assertEquals("Tesla Model 3", createdVehicle.getVehicleModel(), "Vehicle model should match");
    assertEquals("Electric", createdVehicle.getVehicleType(), "Vehicle type should match");

    verify(vehicleRepository, times(1)).save(newVehicle);
    System.out.println("Created Vehicle: " + createdVehicle);
  }

  @Test
  @Order(2)
  void testCreateVehicleWithNull() {
    // Arrange
    when(vehicleRepository.save(null)).thenThrow(new IllegalArgumentException("Vehicle cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      vehicleService.create(null);
    }, "Should throw exception when creating null vehicle");

    verify(vehicleRepository, times(1)).save(null);
    System.out.println("Create with null vehicle throws exception as expected");
  }

  @Test
  @Order(3)
  void testReadVehicle() {
    // Arrange
    when(vehicleRepository.findById(1L)).thenReturn(Optional.of(testVehicle1));

    // Act
    Vehicle foundVehicle = vehicleService.read(1L);

    // Assert
    assertNotNull(foundVehicle, "Found vehicle should not be null");
    assertEquals(1L, foundVehicle.getId(), "Vehicle ID should match");
    assertEquals("Toyota Camry", foundVehicle.getVehicleModel(), "Vehicle model should match");
    assertEquals("Sedan", foundVehicle.getVehicleType(), "Vehicle type should match");

    verify(vehicleRepository, times(1)).findById(1L);
    System.out.println("Read Vehicle: " + foundVehicle);
  }

  @Test
  @Order(4)
  void testReadVehicleNotFound() {
    // Arrange
    when(vehicleRepository.findById(999L)).thenReturn(Optional.empty());

    // Act
    Vehicle foundVehicle = vehicleService.read(999L);

    // Assert
    assertNull(foundVehicle, "Vehicle should be null when not found");

    verify(vehicleRepository, times(1)).findById(999L);
    System.out.println("Read non-existent vehicle returns null as expected");
  }

  @Test
  @Order(5)
  void testReadVehicleWithNullId() {
    // Arrange
    when(vehicleRepository.findById(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      vehicleService.read(null);
    }, "Should throw exception when reading with null ID");

    verify(vehicleRepository, times(1)).findById(null);
    System.out.println("Read with null ID throws exception as expected");
  }

  @Test
  @Order(6)
  void testUpdateVehicle() {
    // Arrange
    Vehicle updatedVehicle = VehicleFactory.createVehicle(1L, "Toyota Camry Hybrid", "Hybrid Sedan");
    when(vehicleRepository.save(any(Vehicle.class))).thenReturn(updatedVehicle);

    // Act
    Vehicle result = vehicleService.update(updatedVehicle);

    // Assert
    assertNotNull(result, "Updated vehicle should not be null");
    assertEquals(1L, result.getId(), "Vehicle ID should match");
    assertEquals("Toyota Camry Hybrid", result.getVehicleModel(), "Updated vehicle model should match");
    assertEquals("Hybrid Sedan", result.getVehicleType(), "Updated vehicle type should match");

    verify(vehicleRepository, times(1)).save(updatedVehicle);
    System.out.println("Updated Vehicle: " + result);
  }

  @Test
  @Order(7)
  void testUpdateVehicleWithNull() {
    // Arrange
    when(vehicleRepository.save(null)).thenThrow(new IllegalArgumentException("Vehicle cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      vehicleService.update(null);
    }, "Should throw exception when updating null vehicle");

    verify(vehicleRepository, times(1)).save(null);
    System.out.println("Update with null vehicle throws exception as expected");
  }

  @Test
  @Order(8)
  void testDeleteVehicle() {
    // Arrange
    doNothing().when(vehicleRepository).deleteById(1L);

    // Act
    vehicleService.delete(1L);

    // Assert
    verify(vehicleRepository, times(1)).deleteById(1L);
    System.out.println("Vehicle deleted successfully");
  }

  @Test
  @Order(9)
  void testDeleteVehicleWithNullId() {
    // Arrange
    doThrow(new IllegalArgumentException("ID cannot be null")).when(vehicleRepository).deleteById(null);

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      vehicleService.delete(null);
    }, "Should throw exception when deleting with null ID");

    verify(vehicleRepository, times(1)).deleteById(null);
    System.out.println("Delete with null ID throws exception as expected");
  }

  @Test
  @Order(10)
  void testGetAllVehicles() {
    // Arrange
    List<Vehicle> vehicles = Arrays.asList(testVehicle1, testVehicle2, testVehicle3);
    when(vehicleRepository.findAll()).thenReturn(vehicles);

    // Act
    List<Vehicle> result = vehicleService.getAllVehicles();

    // Assert
    assertNotNull(result, "Vehicle list should not be null");
    assertEquals(3, result.size(), "Should return 3 vehicles");
    assertTrue(result.contains(testVehicle1), "Should contain test vehicle 1");
    assertTrue(result.contains(testVehicle2), "Should contain test vehicle 2");
    assertTrue(result.contains(testVehicle3), "Should contain test vehicle 3");

    verify(vehicleRepository, times(1)).findAll();
    System.out.println("All Vehicles: " + result);
  }

  @Test
  @Order(11)
  void testGetAllVehiclesEmpty() {
    // Arrange
    when(vehicleRepository.findAll()).thenReturn(Arrays.asList());

    // Act
    List<Vehicle> result = vehicleService.getAllVehicles();

    // Assert
    assertNotNull(result, "Empty vehicle list should not be null");
    assertEquals(0, result.size(), "Should return empty list");
    assertTrue(result.isEmpty(), "List should be empty");

    verify(vehicleRepository, times(1)).findAll();
    System.out.println("Empty vehicle list returned as expected");
  }

  @Test
  @Order(12)
  void testVehicleServiceConstructor() {
    // Arrange & Act
    VehicleServiceImpl newService = new VehicleServiceImpl(vehicleRepository);

    // Assert
    assertNotNull(newService, "Service should not be null");
    System.out.println("VehicleService constructor test passed");
  }

  @Test
  @Order(13)
  void testCreateVehicleWithZeroId() {
    // Arrange
    Vehicle vehicleWithZeroId = VehicleFactory.createVehicle(0L, "Test Vehicle", "Test Type");
    when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicleWithZeroId);

    // Act
    Vehicle createdVehicle = vehicleService.create(vehicleWithZeroId);

    // Assert
    assertNotNull(createdVehicle, "Vehicle with zero ID should be created");
    assertEquals(0L, createdVehicle.getId(), "Vehicle ID should be zero");

    verify(vehicleRepository, times(1)).save(vehicleWithZeroId);
    System.out.println("Created Vehicle with zero ID: " + createdVehicle);
  }

  @Test
  @Order(14)
  void testCreateVehicleWithNegativeId() {
    // Arrange
    Vehicle vehicleWithNegativeId = VehicleFactory.createVehicle(-1L, "Test Vehicle", "Test Type");
    when(vehicleRepository.save(any(Vehicle.class))).thenReturn(vehicleWithNegativeId);

    // Act
    Vehicle createdVehicle = vehicleService.create(vehicleWithNegativeId);

    // Assert
    assertNotNull(createdVehicle, "Vehicle with negative ID should be created");
    assertEquals(-1L, createdVehicle.getId(), "Vehicle ID should be negative");

    verify(vehicleRepository, times(1)).save(vehicleWithNegativeId);
    System.out.println("Created Vehicle with negative ID: " + createdVehicle);
  }
}