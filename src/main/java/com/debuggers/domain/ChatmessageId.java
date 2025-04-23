package com.debuggers.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.util.Objects;

@Embeddable
public class ChatmessageId implements java.io.Serializable {
    private static final long serialVersionUID = -4802433813189347069L;
    @Column(name = "chat_id", nullable = false)
    private Integer chatId;

    @Column(name = "message_id", nullable = false)
    private Integer messageId;

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
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