package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle", schema = "prt3debuggers")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Long id;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    public Long getId() {
        return id;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public Vehicle(){

    }

    private Vehicle(Builder builder){
        this.id = builder.id;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleType = builder.vehicleType;
    }

    public static class Builder {
        private Long id;
        private String vehicleModel;
        private String vehicleType;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setVehicleModel(String vehicleModel) {
            this.vehicleModel = vehicleModel;
            return this;
        }

        public Builder setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }
}