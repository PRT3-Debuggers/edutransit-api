package com.debuggers.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "chat", schema = "prt3debuggers")
public class Chat {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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

    public Chat() {
    }

    private Chat(Builder builder) {
        this.id = builder.id;
        this.parent = builder.parent;
        this.driver = builder.driver;
        this.dateCreated = builder.dateCreated;
    }

    public Long getId() {
        return id;
    }

    public Parent getParent() {
        return parent;
    }

    public Driver getDriver() {
        return driver;
    }

    public Instant getDateCreated() {
        return dateCreated;
    }

    public static class Builder{
        private Long id;
        private Parent parent;
        private Driver driver;
        private Instant dateCreated;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setParent(Parent parent) {
            this.parent = parent;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setDateCreated(Instant dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Chat build(){
            return new Chat(this);
        }
    }
}