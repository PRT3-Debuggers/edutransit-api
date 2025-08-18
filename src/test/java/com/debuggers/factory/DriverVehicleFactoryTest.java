//package com.debuggers.factory;
//
//import com.debuggers.domain.*;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DriverVehicleFactoryTest {
//    private static DrivervehicleId drivervehicleId = new DrivervehicleId();
//
//    private static User user1;
//    private static Driver driver1 = DriverFactory.createDriver(130L,user1,"battery","10","1");
//    private static  Vehicle vehicle1 = VehicleFactory.createVehicle(410L,"Corolla","Sedan");
//
//    private static Drivervehicle drivervehicle1 = DriverVehicleFactory.createDriverVehicle(drivervehicleId, vehicle1, driver1);
//
//    @Test
//    void testCreateDriverVehicle(){
////        drivervehicleId.setDriverId(130L);
////        drivervehicleId.setVehicleId(410L);
//        user1 = UserFactory.createUser(220L,"Joe","Doe","jdoe@mail.com","pscode");
//        assertNotNull(user1);
//        System.out.println(user1.toString());
//    }
//
//    @Test
//    void testCreateDriver(){
//        assertNotNull(driver1);
//        System.out.println(driver1.toString());
//    }
//
//}