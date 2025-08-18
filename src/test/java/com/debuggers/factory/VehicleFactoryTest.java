package com.debuggers.factory;

import com.debuggers.domain.Vehicle;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VehicleFactoryTest {
    private static Vehicle vehicle = VehicleFactory.createVehicle(4L,"Ferrari","Gran Touring");
    private static Vehicle vehicle1 = VehicleFactory.createVehicle(3L,"Ferrari","Gran Touring");
    private static Vehicle vehicle2 = VehicleFactory.createVehicle(2L,"Ferrari","Gran Touring");

    @Test
    void testCreate(){}



}