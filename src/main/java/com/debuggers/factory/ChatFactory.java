package com.debuggers.factory;

import com.debuggers.domain.Chat;
import com.debuggers.domain.Driver;
import com.debuggers.domain.Parent;

import java.time.Instant;

public class ChatFactory {
    public static Chat createChat(
            Long id,
            Parent parent,
            Driver driver,
            Instant dateCreated) {

        if(
                id.equals(null) || parent.equals(null) || driver.equals(null) || dateCreated.equals(null)
        ){
            return null;
        }
        return new Chat.Builder()
                .setId(id)
                .setParent(parent)
                .setDriver(driver)
                .setDateCreated(dateCreated)
                .build();
    }
}
