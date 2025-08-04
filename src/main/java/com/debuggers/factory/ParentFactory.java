package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.Util.helper;
import com.debuggers.domain.Parent;
import com.debuggers.domain.User;

public class ParentFactory {

    // Used if you want to generate an ID internally
    public static Long createUserId() {
        return helper.generateId(); // ✅ Create a new method that returns a random long
    }


    public static Parent createUser(
            Long id,
            User user
    ){


        if(helper.isEmptyOrNullString(String.valueOf(user))){
            return null;
        }

        return new Parent.Builder()
                .setId(createUserId())
                .setUser(user)
                .build();
    }
}
