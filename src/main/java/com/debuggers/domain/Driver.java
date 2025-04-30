package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "driver", schema = "prt3debuggers")
public class Driver {
    @Id
    @Column(name = "driver_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

    @Column(name = "criminal_record")
    private String criminalRecord;

    @Column(name = "max_passengers")
    private String maxPassengers;

    @Column(name = "available_seats")
    private String availableSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.debuggers.domain.User getUser() {
        return user;
    }

    public void setUser(com.debuggers.domain.User user) {
        this.user = user;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public String getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

}