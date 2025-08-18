package com.debuggers.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DrivervehicleId implements Serializable {

    private static final long serialVersionUID = -1539075642753934757L;

    @Column(name = "driver_id", nullable = false)
    private Long driverId;

    @Column(name = "vehicle_id", nullable = false)
    private Long vehicleId;

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;

        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;

        DrivervehicleId entity = (DrivervehicleId) o;

        return Objects.equals(driverId,entity.driverId) && 
               Objects.equals(vehicleId, entity.vehicleId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(driverId, vehicleId);
    }
}
