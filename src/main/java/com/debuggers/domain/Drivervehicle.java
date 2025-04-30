package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "drivervehicle", schema = "prt3debuggers")
public class Drivervehicle {
    @EmbeddedId
    private DrivervehicleId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @MapsId("vehicleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private com.debuggers.domain.Vehicle vehicle;

    public DrivervehicleId getId() {
        return id;
    }

    public void setId(DrivervehicleId id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public com.debuggers.domain.Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(com.debuggers.domain.Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}