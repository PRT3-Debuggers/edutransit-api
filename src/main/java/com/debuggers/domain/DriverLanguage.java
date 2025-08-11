package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "driverlanguage", schema = "prt3debuggers")
public class DriverLanguage {
    @EmbeddedId
    private DriverlanguageId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @MapsId("languageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    public DriverlanguageId getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public Language getLanguage() {
        return language;
    }

    public DriverLanguage() {
    }

    private DriverLanguage(Builder builder){
        this.driver = builder.driver;
        this.id = builder.id;
        this.language = builder.language;
    }

    public static class Builder{
        private DriverlanguageId id;
        private Driver driver;
        private Language language;

        public Builder setId(DriverlanguageId id) {
            this.id = id;
            return this;
        }

        public Builder setDriver(Driver driver){
            this.driver = driver;
            return this;
        }

        public Builder setLanguage(Language language){
            this.language = language;
            return this;
        }

        public DriverLanguage build(){
            return new DriverLanguage(this);
        }
    }
}
