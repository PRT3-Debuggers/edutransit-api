package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "drivervehicle", schema = "prt3debuggers")
public class DriverVehicle {
    @EmbeddedId
    private DrivervehicleId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @MapsId("vehicleId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    public DrivervehicleId getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public DriverVehicle(){

    }

    private DriverVehicle(Builder builder){
        this.id = builder.id;
        this.driver = builder.driver;
        this.vehicle = builder.vehicle;
    }

    public static class Builder{
        private DrivervehicleId id;
        private Driver driver;
        private Vehicle vehicle;

        public Builder setId(DrivervehicleId id) {
            this.id = id;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public DriverVehicle build(){
            return new DriverVehicle(this);
        }
    }
}
