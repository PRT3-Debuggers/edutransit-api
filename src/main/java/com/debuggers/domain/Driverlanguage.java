package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "driverlanguage", schema = "prt3debuggers")
public class Driverlanguage {
    @EmbeddedId
    private DriverlanguageId id;

    @MapsId("driverId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @MapsId("languageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "language_id", nullable = false)
    private com.debuggers.domain.Language language;

    public DriverlanguageId getId() {
        return id;
    }

    public void setId(DriverlanguageId id) {
        this.id = id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public com.debuggers.domain.Language getLanguage() {
        return language;
    }

    public void setLanguage(com.debuggers.domain.Language language) {
        this.language = language;
    }

}