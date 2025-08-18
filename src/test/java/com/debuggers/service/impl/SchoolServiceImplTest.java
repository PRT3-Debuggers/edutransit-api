package com.debuggers.service.impl;

import com.debuggers.domain.School;
import com.debuggers.factory.SchoolFactory;
import com.debuggers.repository.SchoolRepository;
import com.debuggers.service.impl.SchoolServiceImpl;
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
class SchoolServiceImplTest {

  @Mock
  private SchoolRepository schoolRepository;

  @InjectMocks
  private SchoolServiceImpl schoolService;

  private School testSchool1;
  private School testSchool2;
  private School testSchool3;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    // Create test schools
    testSchool1 = SchoolFactory.createSchool(1L, "Springfield Elementary", "123 Main Street, Springfield");
    testSchool2 = SchoolFactory.createSchool(2L, "Lincoln High School", "456 Oak Avenue, Lincoln");
    testSchool3 = SchoolFactory.createSchool(3L, "University Prep Academy", "789 College Boulevard, Metro City");
  }

  @Test
  @Order(1)
  void testCreateSchool() {
    // Arrange
    School newSchool = SchoolFactory.createSchool(4L, "New Academy", "321 Innovation Drive, Tech City");
    when(schoolRepository.save(any(School.class))).thenReturn(newSchool);

    // Act
    School createdSchool = schoolService.create(newSchool);

    // Assert
    assertNotNull(createdSchool, "Created school should not be null");
    assertEquals(4L, createdSchool.getId(), "School ID should match");
    assertEquals("New Academy", createdSchool.getSchoolName(), "School name should match");
    assertEquals("321 Innovation Drive, Tech City", createdSchool.getSchoolAddress(), "School address should match");

    verify(schoolRepository, times(1)).save(newSchool);
    System.out.println("Created School: " + createdSchool);
  }

  @Test
  @Order(2)
  void testCreateSchoolWithNull() {
    // Arrange
    when(schoolRepository.save(null)).thenThrow(new IllegalArgumentException("School cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      schoolService.create(null);
    }, "Should throw exception when creating null school");

    verify(schoolRepository, times(1)).save(null);
    System.out.println("Create with null school throws exception as expected");
  }

  @Test
  @Order(3)
  void testReadSchool() {
    // Arrange
    when(schoolRepository.findById(1L)).thenReturn(Optional.of(testSchool1));

    // Act
    School foundSchool = schoolService.read(1L);

    // Assert
    assertNotNull(foundSchool, "Found school should not be null");
    assertEquals(1L, foundSchool.getId(), "School ID should match");
    assertEquals("Springfield Elementary", foundSchool.getSchoolName(), "School name should match");
    assertEquals("123 Main Street, Springfield", foundSchool.getSchoolAddress(), "School address should match");

    verify(schoolRepository, times(1)).findById(1L);
    System.out.println("Read School: " + foundSchool);
  }

  @Test
  @Order(4)
  void testReadSchoolNotFound() {
    // Arrange
    when(schoolRepository.findById(999L)).thenReturn(Optional.empty());

    // Act
    School foundSchool = schoolService.read(999L);

    // Assert
    assertNull(foundSchool, "School should be null when not found");

    verify(schoolRepository, times(1)).findById(999L);
    System.out.println("Read non-existent school returns null as expected");
  }

  @Test
  @Order(5)
  void testReadSchoolWithNullId() {
    // Arrange
    when(schoolRepository.findById(null)).thenThrow(new IllegalArgumentException("ID cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      schoolService.read(null);
    }, "Should throw exception when reading with null ID");

    verify(schoolRepository, times(1)).findById(null);
    System.out.println("Read with null ID throws exception as expected");
  }

  @Test
  @Order(6)
  void testUpdateSchool() {
    // Arrange
    School updatedSchool = SchoolFactory.createSchool(1L, "Springfield Elementary (Updated)",
        "123 Main Street, Springfield, CA 90210");
    when(schoolRepository.save(any(School.class))).thenReturn(updatedSchool);

    // Act
    School result = schoolService.update(updatedSchool);

    // Assert
    assertNotNull(result, "Updated school should not be null");
    assertEquals(1L, result.getId(), "School ID should match");
    assertEquals("Springfield Elementary (Updated)", result.getSchoolName(), "Updated school name should match");
    assertEquals("123 Main Street, Springfield, CA 90210", result.getSchoolAddress(),
        "Updated school address should match");

    verify(schoolRepository, times(1)).save(updatedSchool);
    System.out.println("Updated School: " + result);
  }

  @Test
  @Order(7)
  void testUpdateSchoolWithNull() {
    // Arrange
    when(schoolRepository.save(null)).thenThrow(new IllegalArgumentException("School cannot be null"));

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      schoolService.update(null);
    }, "Should throw exception when updating null school");

    verify(schoolRepository, times(1)).save(null);
    System.out.println("Update with null school throws exception as expected");
  }

  @Test
  @Order(8)
  void testDeleteSchool() {
    // Arrange
    doNothing().when(schoolRepository).deleteById(1L);

    // Act
    schoolService.delete(1L);

    // Assert
    verify(schoolRepository, times(1)).deleteById(1L);
    System.out.println("School deleted successfully");
  }

  @Test
  @Order(9)
  void testDeleteSchoolWithNullId() {
    // Arrange
    doThrow(new IllegalArgumentException("ID cannot be null")).when(schoolRepository).deleteById(null);

    // Act & Assert
    assertThrows(IllegalArgumentException.class, () -> {
      schoolService.delete(null);
    }, "Should throw exception when deleting with null ID");

    verify(schoolRepository, times(1)).deleteById(null);
    System.out.println("Delete with null ID throws exception as expected");
  }

  @Test
  @Order(10)
  void testGetAllSchools() {
    // Arrange
    List<School> schools = Arrays.asList(testSchool1, testSchool2, testSchool3);
    when(schoolRepository.findAll()).thenReturn(schools);

    // Act
    List<School> result = schoolService.getAllSchools();

    // Assert
    assertNotNull(result, "School list should not be null");
    assertEquals(3, result.size(), "Should return 3 schools");
    assertTrue(result.contains(testSchool1), "Should contain test school 1");
    assertTrue(result.contains(testSchool2), "Should contain test school 2");
    assertTrue(result.contains(testSchool3), "Should contain test school 3");

    verify(schoolRepository, times(1)).findAll();
    System.out.println("All Schools: " + result);
  }

  @Test
  @Order(11)
  void testGetAllSchoolsEmpty() {
    // Arrange
    when(schoolRepository.findAll()).thenReturn(Arrays.asList());

    // Act
    List<School> result = schoolService.getAllSchools();

    // Assert
    assertNotNull(result, "Empty school list should not be null");
    assertEquals(0, result.size(), "Should return empty list");
    assertTrue(result.isEmpty(), "List should be empty");

    verify(schoolRepository, times(1)).findAll();
    System.out.println("Empty school list returned as expected");
  }

  @Test
  @Order(12)
  void testSchoolServiceConstructor() {
    // Arrange & Act
    SchoolServiceImpl newService = new SchoolServiceImpl(schoolRepository);

    // Assert
    assertNotNull(newService, "Service should not be null");
    System.out.println("SchoolService constructor test passed");
  }

  @Test
  @Order(13)
  void testCreateSchoolWithZeroId() {
    // Arrange
    School schoolWithZeroId = SchoolFactory.createSchool(0L, "Test School", "Test Address");
    when(schoolRepository.save(any(School.class))).thenReturn(schoolWithZeroId);

    // Act
    School createdSchool = schoolService.create(schoolWithZeroId);

    // Assert
    assertNotNull(createdSchool, "School with zero ID should be created");
    assertEquals(0L, createdSchool.getId(), "School ID should be zero");

    verify(schoolRepository, times(1)).save(schoolWithZeroId);
    System.out.println("Created School with zero ID: " + createdSchool);
  }

  @Test
  @Order(14)
  void testCreateSchoolWithNegativeId() {
    // Arrange
    School schoolWithNegativeId = SchoolFactory.createSchool(-1L, "Test School", "Test Address");
    when(schoolRepository.save(any(School.class))).thenReturn(schoolWithNegativeId);

    // Act
    School createdSchool = schoolService.create(schoolWithNegativeId);

    // Assert
    assertNotNull(createdSchool, "School with negative ID should be created");
    assertEquals(-1L, createdSchool.getId(), "School ID should be negative");

    verify(schoolRepository, times(1)).save(schoolWithNegativeId);
    System.out.println("Created School with negative ID: " + createdSchool);
  }

  @Test
  @Order(15)
  void testCreateSchoolWithLongStrings() {
    // Arrange
    String longName = "This is a very long school name that contains many characters to test the service layer and ensure it works correctly with extended text input";
    String longAddress = "This is a very long school address that contains many characters including numbers like 12345 and special characters like @#$%^&*() to test the service layer and ensure it works correctly with extended text input";

    School schoolWithLongStrings = SchoolFactory.createSchool(100L, longName, longAddress);
    when(schoolRepository.save(any(School.class))).thenReturn(schoolWithLongStrings);

    // Act
    School createdSchool = schoolService.create(schoolWithLongStrings);

    // Assert
    assertNotNull(createdSchool, "School with long strings should be created");
    assertEquals(100L, createdSchool.getId(), "School ID should match");
    assertEquals(longName, createdSchool.getSchoolName(), "Long school name should match");
    assertEquals(longAddress, createdSchool.getSchoolAddress(), "Long school address should match");

    verify(schoolRepository, times(1)).save(schoolWithLongStrings);
    System.out.println("Created School with long strings: " + createdSchool);
  }

  @Test
  @Order(16)
  void testUpdateSchoolWithSameData() {
    // Arrange
    when(schoolRepository.save(any(School.class))).thenReturn(testSchool1);

    // Act
    School result = schoolService.update(testSchool1);

    // Assert
    assertNotNull(result, "School should be updated even with same data");
    assertEquals(testSchool1.getId(), result.getId(), "School ID should match");
    assertEquals(testSchool1.getSchoolName(), result.getSchoolName(), "School name should match");
    assertEquals(testSchool1.getSchoolAddress(), result.getSchoolAddress(), "School address should match");

    verify(schoolRepository, times(1)).save(testSchool1);
    System.out.println("Updated School with same data: " + result);
  }
}