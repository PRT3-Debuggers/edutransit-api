package com.debuggers.domain;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "vehicle", schema = "prt3debuggers")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id", nullable = false)
    private Long id;

    @Column(name = "vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name = "vehicle_type", nullable = false)
    private String vehicleType;

    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        this.id = builder.id;
        this.vehicleModel = builder.vehicleModel;
        this.vehicleType = builder.vehicleType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
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

        // ✅ FIXED: copy method is now inside Builder class
        public Builder copy(Vehicle vehicle) {
            this.id = vehicle.id;
            this.vehicleModel = vehicle.vehicleModel;
            this.vehicleType = vehicle.vehicleType;
            return this;
        }

        // ✅ FIXED: build method is now inside Builder class
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}
