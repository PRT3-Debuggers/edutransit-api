package com.debuggers.domain;
/*

     Author: Bonga Velem (220052379)

    */
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "driver", schema = "prt3debuggers")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "criminal_Record")
    private String criminalRecord;

    @Column(name = "max_Passengers")
    private String maxPassengers;

    @Column(name = "available_Seats")
    private String availableSeats;

    public Driver() {
    }

    public Driver(Builder builder) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public void setMaxPassengers(String maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", user=" + user +
                ", criminalRecord='" + criminalRecord + '\'' +
                ", maxPassengers='" + maxPassengers + '\'' +
                ", availableSeats='" + availableSeats + '\'' +
                '}';
    }

    public static class Builder {
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

        public Builder setCriminalRecord(String criminalRecord) {
            this.criminalRecord = criminalRecord;
            return this;
        }

        public Builder setMaxPassengers(String maxPassengers) {
            this.maxPassengers = maxPassengers;
            return this;
        }

        public Builder setAvailableSeats(String availableSeats) {
            this.availableSeats = availableSeats;
            return this;
        }

        public Builder copy(Driver driver) {
            this.id = driver.id;
            this.user = driver.user;
            this.criminalRecord = driver.criminalRecord;
            this.maxPassengers = driver.maxPassengers;
            this.availableSeats = driver.availableSeats;
            return this;
        }

        public Driver build() {
            return new Driver(this);
        }
    }
}