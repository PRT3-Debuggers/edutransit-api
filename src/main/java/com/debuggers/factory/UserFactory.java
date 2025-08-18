package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.util.Helper;
import com.debuggers.domain.User;

public class UserFactory {

    public static Long createUserId() {
        return Helper.generateId(); // Create a new method that returns a random long
    }



    public static User createUser(
        Long id,
        String firstName,
        String lastName,
        String emailAddress,
        String password

    ) {
    // Validation
    if (Helper.IsEmptyOrNullString(firstName) ||
            Helper.IsEmptyOrNullString(lastName) ||
            !Helper.isValidEmail(emailAddress) ||
            !Helper.isValidPassword(password)) {
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
        if (!Helper.isValidEmail(emailAddress) || !Helper.isValidPassword(password)) {
            return null;
        }

        return new User.Builder()
                .setEmailAddress(emailAddress)
                .setPassword(password)
                .build();
    }

}