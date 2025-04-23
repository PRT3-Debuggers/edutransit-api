package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

    @Column(name = "pfp_number", nullable = false)
    private Integer pfpNumber;

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

    public Integer getPfpNumber() {
        return pfpNumber;
    }

    public void setPfpNumber(Integer pfpNumber) {
        this.pfpNumber = pfpNumber;
    }

}