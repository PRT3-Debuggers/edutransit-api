package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "driverschool", schema = "prt3debuggers")
public class Driverschool {
    @EmbeddedId
    private DriverschoolId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @MapsId("schoolId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "school_id", nullable = false)
    private com.debuggers.domain.School school;

    public DriverschoolId getId() {
        return id;
    }

    public void setId(DriverschoolId id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public com.debuggers.domain.School getSchool() {
        return school;
    }

    public void setSchool(com.debuggers.domain.School school) {
        this.school = school;
    }

}