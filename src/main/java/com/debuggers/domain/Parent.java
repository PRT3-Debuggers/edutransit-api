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

    public Parent(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
    }

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


    public static class Builder{
        private Long id;
        private com.debuggers.domain.User user;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Parent parent){
            this.id = parent.getId();
            this.user = parent.getUser();
            return this;
        }

        public Parent build(){
            return new Parent(this);
        }
    }

}