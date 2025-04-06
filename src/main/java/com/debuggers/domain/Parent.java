package com.debuggers.domain;
/*
Author:Ethan Le Roux
*/
import jakarta.persistence.*;

@Entity
@Table(name="parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private int parentId;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User userId;

    public int getParentId() {
        return parentId;
    }

    public int getUserId() {
        return userId.getUserId();
    }
}
