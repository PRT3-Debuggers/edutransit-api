package com.debuggers.factory;

import com.debuggers.domain.Message;
import com.debuggers.domain.User;

import java.time.Instant;

public class MessageFactory {
    public static Message createMessage(
            Long id,
            User user,
            Instant dateSent,
            String content
    ){
        if(
                id.equals(null) || user == null ||  dateSent == null  ||  content.isEmpty()
        )
        {
            return null;
        }

        return new Message.Builder()
                .setId(id)
                .setUser(user)
                .setDateSent(dateSent)
                .setContent(content)
                .build();
    }
}
