package com.debuggers.factory;

import com.debuggers.domain.School;
import com.debuggers.util.Helper;

public class SchoolFactory {

    public static Long generatedId(){
        return Helper.generateId();
    }

    public static School createSchool(
            Long id,
            String schoolName,
            String schoolAddress

    ){
        if(Helper.IsEmptyOrNullString(schoolName)|| Helper.IsEmptyOrNullString(schoolAddress)){
            return null;
        }
        return new School.Builder()
                .setId(id)
                .setSchoolName(schoolName)
                .setSchoolAddress(schoolAddress)
                .build();
    }
}
