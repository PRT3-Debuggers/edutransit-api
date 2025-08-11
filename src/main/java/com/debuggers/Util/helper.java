package com.debuggers.util;

//import org.apache.commons.validator.routines.EmailValidator;
import java.util.UUID;

public class Helper {

    public static boolean IsEmptyOrNullString(String str) {
        return str == null || str.trim().isEmpty();
    }

//    public static boolean IsValidEmail(String email){
//    }


    public static boolean IsValidPassword(String password) {
        if (password == null)
            return false;
        return true;
    }
}