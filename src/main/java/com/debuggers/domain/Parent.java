package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "parent", schema = "prt3debuggers")
public class Parent {
    @Id
    @Column(name = "parent_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

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

}