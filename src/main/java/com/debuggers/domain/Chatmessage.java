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

    public ChatmessageId getId() {
        return id;
    }

    public void setId(ChatmessageId id) {
        this.id = id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public com.debuggers.domain.Message getMessage() {
        return message;
    }

    public void setMessage(com.debuggers.domain.Message message) {
        this.message = message;
    }

}