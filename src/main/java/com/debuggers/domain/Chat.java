package com.debuggers.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "chat")
public class Chat {
    @Id
    @Column(name = "chat_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parent_id", nullable = false)
    private com.debuggers.domain.Parent parent;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    private com.debuggers.domain.Driver driver;

    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.debuggers.domain.Parent getParent() {
        return parent;
    }

    public void setParent(com.debuggers.domain.Parent parent) {
        this.parent = parent;
    }

    public com.debuggers.domain.Driver getDriver() {
        return driver;
    }

    public void setDriver(com.debuggers.domain.Driver driver) {
        this.driver = driver;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

}