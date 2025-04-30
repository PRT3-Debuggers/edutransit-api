package com.debuggers.factory;

import com.debuggers.domain.User;

public class UserFactory {
    public static User createUser(
            Long id,
            String firstName,
            String lastName,
            String emailAddress,
            String password
    ){
        if(id.equals(null) ||
                firstName.isEmpty() || lastName.isEmpty() ||emailAddress.isEmpty() || password.isEmpty()
        ){
            return null;
        }
        return new User.Builder()
                .setId(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }
}
