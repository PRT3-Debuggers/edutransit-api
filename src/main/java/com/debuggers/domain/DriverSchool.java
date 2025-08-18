package com.debuggers.domain;

import jakarta.persistence.*;

//import java.sql.Driver;

@Entity
@Table(name = "driverschool", schema = "prt3debuggers")
public class DriverSchool {
    @EmbeddedId
    private DriverschoolId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false, insertable = false, updatable = false)
    private Driver driver;

    @MapsId("schoolId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school_id", nullable = false, insertable = false, updatable = false)
    private School school;

    public DriverschoolId getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public School getSchool() {
        return school;
    }

    private DriverSchool() {

    }

    private DriverSchool(Builder builder) {
        this.id = builder.id;
        this.driver = builder.driver;
        this.school = builder.school;
    }

    public static class Builder {
        private DriverschoolId id;
        private Driver driver;
        private School school;

        public Builder setDriverschoolId(DriverschoolId id) {
            this.id = id;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setSchool(School school) {
            this.school = school;
            return this;
        }

        public Builder copy(DriverSchool driverSchool) {
            this.id = driverSchool.id;
            this.driver = driverSchool.driver;
            this.school = driverSchool.school;
            return this;
        }

        public DriverSchool build() {
            return new DriverSchool(this);
        }
    }
}
