package com.debuggers.service.impl;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Driver;
import com.debuggers.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DriverServiceImplTest {

    private DriverRepository driverRepo;
    private DriverServiceImpl driverService;

    private Driver testDriver;

    @BeforeEach
    void setUp() {
        driverRepo = Mockito.mock(DriverRepository.class);
        driverService = new DriverServiceImpl(driverRepo);

        testDriver = new Driver.Builder()
                .setId(1L)
                .setCriminalRecord("None")
                .setMaxPassengers("4")
                .setAvailableSeats("3")
                .build();
    }

    @Test
    void create() {
        when(driverRepo.save(testDriver)).thenReturn(testDriver);

        Driver result = driverService.create(testDriver);

        assertNotNull(result);
        assertEquals(testDriver.getId(), result.getId());
        verify(driverRepo).save(testDriver);
    }

    @Test
    void read() {
        when(driverRepo.findById(1L)).thenReturn(Optional.of(testDriver));

//        Optional<Driver> result = driverService.read(1L);

//        assertTrue(result.isPresent());
//        assertEquals(1L, result.get().getId());
    }

    @Test
    void update() {
        when(driverRepo.existsById(testDriver.getId())).thenReturn(true);
        when(driverRepo.save(testDriver)).thenReturn(testDriver);

        Driver result = driverService.update(testDriver);

        assertNotNull(result);
        verify(driverRepo).save(testDriver);
    }

    @Test
    void delete() {
        driverService.delete(Long.valueOf("1"));
        verify(driverRepo).deleteById(1L);
    }

    @Test
    void findAll() {
        when(driverRepo.findAll()).thenReturn(List.of(testDriver));

        List<Driver> result = driverService.findAll();

        assertEquals(1, result.size());
    }
}