package com.debuggers.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

    @Column(name = "date_sent", nullable = false)
    private Instant dateSent;

    @Lob
    @Column(name = "content")
    private String content;

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

    public Instant getDateSent() {
        return dateSent;
    }

    public void setDateSent(Instant dateSent) {
        this.dateSent = dateSent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}