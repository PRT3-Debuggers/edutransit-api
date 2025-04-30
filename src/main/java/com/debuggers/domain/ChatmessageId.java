package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ChatmessageId implements java.io.Serializable {
    private static final long serialVersionUID = 803928845169514812L;
    @Column(name = "chat_id", nullable = false)
    private Long chatId;

    @Column(name = "message_id", nullable = false)
    private Long messageId;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ChatmessageId entity = (ChatmessageId) o;
        return Objects.equals(this.chatId, entity.chatId) &&
                Objects.equals(this.messageId, entity.messageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, messageId);
    }

}