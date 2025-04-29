package com.debuggers.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "chatmessage", schema = "prt3debuggers")
public class Chatmessage {
    @EmbeddedId
    private ChatmessageId id;

    @MapsId("chatId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @MapsId("messageId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "message_id", nullable = false)
    private com.debuggers.domain.Message message;

    public Chatmessage() {}

    private Chatmessage(Builder builder){
        this.id = builder.id;
        this.chat = builder.chat;
        this.message = builder.message;
    }

    public ChatmessageId getId() {
        return id;
    }

    public Chat getChat() {
        return chat;
    }

    public com.debuggers.domain.Message getMessage() {
        return message;
    }

    public static class Builder{
        private ChatmessageId id;
        private Chat chat;
        private Message message;

        public Builder setId(ChatmessageId id) {
            this.id = id;
            return this;
        }

        public Builder setChat(Chat chat) {
            this.chat = chat;
            return this;
        }

        public Builder setMessage(Message message) {
            this.message = message;
            return this;
        }

        public Chatmessage build(){
            return new Chatmessage(this);
        }
    }

}