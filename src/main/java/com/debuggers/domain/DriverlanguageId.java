package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DriverlanguageId implements Serializable {

    private static final long serialVersionUID = -7958449509087461336L;

    @Column(name = "driver_id", nullable = false)
    private Long driverId;

    @Column(name = "language_id", nullable = false)
    private Long languageId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null ||Hibernate.getClass(this) != Hibernate.getClass(o))
                return false;

        DriverlanguageId entity = (DriverlanguageId) o;

            return Objects.equals(driverId,entity.driverId) &&
                    Objects.equals(languageId,entity.languageId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(driverId);
    }
}
