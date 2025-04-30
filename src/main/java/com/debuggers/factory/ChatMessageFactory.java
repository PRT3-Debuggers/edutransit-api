package com.debuggers.factory;

import com.debuggers.domain.Chat;
import com.debuggers.domain.Chatmessage;
import com.debuggers.domain.ChatmessageId;
import com.debuggers.domain.Message;

public class ChatMessageFactory {
    public static Chatmessage createChatMessage(
            ChatmessageId id,
            Chat chat,
            Message message
    ){
        if(
                id == null || chat == null || message == null
        )
        {
            return null;
        }

        return new Chatmessage.Builder()
                .setId(id)
                .setChat(chat)
                .setMessage(message)
                .build();
    }
}
