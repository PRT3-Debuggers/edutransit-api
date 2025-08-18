package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.Util.helper;
import com.debuggers.domain.User;

public class UserFactory {

    public static Long createUserId() {
        return helper.generateId(); // ✅ Create a new method that returns a random long
    }

//    public static User createUser(
//            String id,
//            String firstName,
//            String lastName,
//            String emailAddress,
//            String password
//    ) {
//        // Validation
//        String idNumber = helper.generateId(id);
//
//        if (helper.isEmptyOrNullString(firstName)) {
//            System.out.println("❌ First name is empty or null");
//            return null;
//        }
//
//        if (helper.isEmptyOrNullString(lastName)) {
//            System.out.println("❌ Last name is empty or null");
//            return null;
//        }
//
//        if (!helper.isValidEmail(emailAddress)) {
//            System.out.println("❌ Invalid email format: " + emailAddress);
//            return null;
//        }
//
//        if (!helper.isValidPassword(password)) {
//            System.out.println("❌ Password is invalid: " + password);
//            return null;
//        }
//
//        System.out.println("✅ User validation passed");
//
//        return new User.Builder()
//                .setId(idNumber)
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setEmailAddress(emailAddress)
//                .setPassword(password)
//                .build();
//    }

//    public static User createUser(
//            Long id,
//            String firstName,
//            String lastName,
//            String emailAddress,
//            String password
//    ) {
//        // Validation
//        Long idNumber = Long.valueOf(helper.generateId(String.valueOf(id)));
//        if (helper.isEmptyOrNullString(firstName) ||
//                        helper.isEmptyOrNullString(lastName) ||
//                        !helper.isValidEmail(emailAddress) ||
//                        !helper.isValidPassword(password)) {
//            return null;
//        }
//
//        System.out.println("error here");
//        return new User.Builder()
//                .setId(idNumber)
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setEmailAddress(emailAddress)
//                .setPassword(password)
//                .build();
//
//    }
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
            .setId(id) // ✅ Use provided Long id
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