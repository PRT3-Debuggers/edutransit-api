package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.util.Helper;
import com.debuggers.domain.Parent;
import com.debuggers.domain.User;

public class ParentFactory {




    public static Parent createUser(
            Long id,
            User user
    ){


        if(Helper.IsEmptyOrNullString(String.valueOf(user))){
            return null;
        }

        return new Parent.Builder()
                .setUser(user)
                .build();
    }
}
