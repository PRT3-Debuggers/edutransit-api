package com.debuggers.util;

//import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.UUID;

public class Helper {

    public static boolean IsEmptyOrNullString(String str) {
        return str == null || str.trim().isEmpty();
    }

// Generate a random UUID for primary keys
    public static Long generateId() {
    return Math.abs(UUID.randomUUID().getMostSignificantBits());
}


    public static boolean isValidEmail(String email){
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;

        // Password must have at least:
        // - 1 uppercase letter
        // - 1 lowercase letter
        // - 1 digit
        // - 1 special character
        // - and be at least 5 characters long
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&^_])[A-Za-z\\d@$!%*#?&^_]{5,}$";
        return password.matches(regex);
    }
}