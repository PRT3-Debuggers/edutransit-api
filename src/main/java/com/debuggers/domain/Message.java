package com.debuggers.domain;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "message", schema = "prt3debuggers")
public class Message {
    @Id
    @Column(name = "message_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private com.debuggers.domain.User user;

    @Column(name = "date_sent", nullable = false)
    private Instant dateSent;

    @Lob
    @Column(name = "content")
    private String content;

    public Message() {
    }
    private Message(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.dateSent = builder.dateSent;
        this.content = builder.content;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Instant getDateSent() {
        return dateSent;
    }

    public String getContent() {
        return content;
    }

    public static class Builder{
        private Long id;
        private com.debuggers.domain.User user;
        private Instant dateSent;
        private String content;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setDateSent(Instant dateSent) {
            this.dateSent = dateSent;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Message builder(){
            return new  Message(this);
        }
    }
}