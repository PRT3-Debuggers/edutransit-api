package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DriverschoolId implements Serializable {

    private static final long serialVersionUID = -1280512185502865008L;

    @Column(name = "driver_id", nullable = false)
    private Long driverId;

    @Column(name = "school_id", nullable = false)
    private Long schoolId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverschoolId entity = (DriverschoolId) o;
        return Objects.equals(this.driverId, entity.driverId) &&
                Objects.equals(this.schoolId, entity.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, schoolId);
    }
}
