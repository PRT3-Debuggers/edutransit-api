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
    private User user;

    @Column(name = "criminal_record")
    private String criminalRecord;

    @Column(name = "max_passengers")
    private String maxPassengers;

    @Column(name = "available_seats")
    private String availableSeats;

    public Driver(){
    }

    private Driver(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.criminalRecord = builder.criminalRecord;
        this.maxPassengers = builder.maxPassengers;
        this.availableSeats = builder.availableSeats;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public String getMaxPassengers() {
        return maxPassengers;
    }

    public String getAvailableSeats() {
        return availableSeats;
    }

    public static class Builder{
        private Long id;
        private User user;
        private String criminalRecord;
        private String maxPassengers;
        private String availableSeats;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setCriminalRecord(String criminalRecord){
            this.criminalRecord = criminalRecord;
            return this;
        }

        public Builder setMaxPassengers (String maxPassengers) {
            this.maxPassengers = maxPassengers;
            return this;
        }

        public Builder setAvailableSeats(String availableSeats) {
            this.availableSeats = availableSeats;
            return this;
        }

        public Driver build()   {
            return new Driver(this);
        }
    }

}