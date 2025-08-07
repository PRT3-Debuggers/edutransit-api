package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.Util.helper;
import com.debuggers.domain.User;

public class UserFactory {

public static User createUser(
        Long id,
        String firstName,
        String lastName,
        String emailAddress,
        String password
) {
    // Validation
    if (helper.isEmptyOrNullString(firstName) ||
            helper.isEmptyOrNullString(lastName) ||
            !helper.isValidEmail(emailAddress) ||
            !helper.isValidPassword(password)) {
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

    public static User loginUser(String emailAddress, String password) {
        if (!helper.isValidEmail(emailAddress) || !helper.isValidPassword(password)) {
            return null;
        }

        return new User.Builder()
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }

}