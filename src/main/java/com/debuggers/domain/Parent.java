package com.debuggers.domain;
/*

     Author: Bonga Velem (220052379)

    */
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "parent", schema = "prt3debuggers")
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id", nullable = false)
    private Long id;

    /**
     *
     */
    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "user_id", nullable = false)
    // private User user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    public Parent() {
    }

    public Parent(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }

    public static class Builder {
        private Long id;
        private User user;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Parent parent) {
            this.id = parent.id;
            this.user = parent.user;
            return this;
        }

        public Parent build() {
            return new Parent(this);
        }
    }
}