package com.debuggers.factory;

import com.debuggers.domain.Parent;
import com.debuggers.domain.User;

public class ParentFactory {
    public static Parent createParent(Long id, User user) {
        if (id == null || user == null) {
            return null;
        }

        return new Parent.Builder()
                .setId(id)
                .setUser(user)
                .build();
    }
}
