package com.debuggers.factory;

import com.debuggers.domain.School;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SchoolFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @Order(1)
    void testGeneratedId() {
        // Test that generatedId returns a non-null Long value
        Long id1 = SchoolFactory.generatedId();
        Long id2 = SchoolFactory.generatedId();

        assertNotNull(id1, "Generated ID should not be null");
        assertNotNull(id2, "Generated ID should not be null");
        assertTrue(id1 instanceof Long, "Generated ID should be of type Long");
        assertTrue(id2 instanceof Long, "Generated ID should be of type Long");

        // IDs should be different (random generation)
        assertNotEquals(id1, id2, "Generated IDs should be different");

        System.out.println("Generated ID 1: " + id1);
        System.out.println("Generated ID 2: " + id2);
    }

    @Test
    @Order(2)
    void testCreateSchoolWithValidData() {
        // Test creating a school with valid data
        Long id = 100L;
        String schoolName = "Test Primary School";
        String schoolAddress = "123 Test Street, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNotNull(school, "School should not be null");
        assertEquals(id, school.getId(), "School ID should match");
        assertEquals(schoolName, school.getSchoolName(), "School name should match");
        assertEquals(schoolAddress, school.getSchoolAddress(), "School address should match");

        System.out.println("Created School: " + school);
    }

    @Test
    @Order(3)
    void testCreateSchoolWithNullSchoolName() {
        // Test creating a school with null school name
        Long id = 101L;
        String schoolName = null;
        String schoolAddress = "456 Test Avenue, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school name is null");
        System.out.println("School creation with null name returned: " + school);
    }

    @Test
    @Order(4)
    void testCreateSchoolWithEmptySchoolName() {
        // Test creating a school with empty school name
        Long id = 102L;
        String schoolName = "";
        String schoolAddress = "789 Test Road, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school name is empty");
        System.out.println("School creation with empty name returned: " + school);
    }

    @Test
    @Order(5)
    void testCreateSchoolWithWhitespaceSchoolName() {
        // Test creating a school with whitespace-only school name
        Long id = 103L;
        String schoolName = "   ";
        String schoolAddress = "321 Test Lane, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school name is only whitespace");
        System.out.println("School creation with whitespace name returned: " + school);
    }

    @Test
    @Order(6)
    void testCreateSchoolWithNullSchoolAddress() {
        // Test creating a school with null school address
        Long id = 104L;
        String schoolName = "Test Secondary School";
        String schoolAddress = null;

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school address is null");
        System.out.println("School creation with null address returned: " + school);
    }

    @Test
    @Order(7)
    void testCreateSchoolWithEmptySchoolAddress() {
        // Test creating a school with empty school address
        Long id = 105L;
        String schoolName = "Test High School";
        String schoolAddress = "";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school address is empty");
        System.out.println("School creation with empty address returned: " + school);
    }

    @Test
    @Order(8)
    void testCreateSchoolWithWhitespaceSchoolAddress() {
        // Test creating a school with whitespace-only school address
        Long id = 106L;
        String schoolName = "Test College";
        String schoolAddress = "   ";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when school address is only whitespace");
        System.out.println("School creation with whitespace address returned: " + school);
    }

    @Test
    @Order(9)
    void testCreateSchoolWithBothNullValues() {
        // Test creating a school with both null values
        Long id = 107L;
        String schoolName = null;
        String schoolAddress = null;

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNull(school, "School should be null when both name and address are null");
        System.out.println("School creation with both null values returned: " + school);
    }

    @Test
    @Order(10)
    void testCreateSchoolWithZeroId() {
        // Test creating a school with zero ID
        Long id = 0L;
        String schoolName = "Test Elementary School";
        String schoolAddress = "654 Test Boulevard, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNotNull(school, "School should not be null with zero ID");
        assertEquals(id, school.getId(), "School ID should be zero");
        assertEquals(schoolName, school.getSchoolName(), "School name should match");
        assertEquals(schoolAddress, school.getSchoolAddress(), "School address should match");

        System.out.println("Created School with zero ID: " + school);
    }

    @Test
    @Order(11)
    void testCreateSchoolWithNegativeId() {
        // Test creating a school with negative ID
        Long id = -100L;
        String schoolName = "Test Academy";
        String schoolAddress = "987 Test Circle, Test City";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNotNull(school, "School should not be null with negative ID");
        assertEquals(id, school.getId(), "School ID should be negative");
        assertEquals(schoolName, school.getSchoolName(), "School name should match");
        assertEquals(schoolAddress, school.getSchoolAddress(), "School address should match");

        System.out.println("Created School with negative ID: " + school);
    }

    @Test
    @Order(12)
    void testCreateSchoolWithLongStrings() {
        // Test creating a school with very long strings
        Long id = 999L;
        String schoolName = "This is a very long school name that contains many characters to test the validation logic and ensure it works correctly with extended text input";
        String schoolAddress = "This is a very long school address that contains many characters including numbers like 12345 and special characters like @#$%^&*() to test the validation logic and ensure it works correctly with extended text input";

        School school = SchoolFactory.createSchool(id, schoolName, schoolAddress);

        assertNotNull(school, "School should not be null with long strings");
        assertEquals(id, school.getId(), "School ID should match");
        assertEquals(schoolName, school.getSchoolName(), "School name should match");
        assertEquals(schoolAddress, school.getSchoolAddress(), "School address should match");

        System.out.println("Created School with long strings: " + school);
    }
}