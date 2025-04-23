package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.debuggers.domain.User getUser() {
        return user;
    }

    public void setUser(com.debuggers.domain.User user) {
        this.user = user;
    }

}