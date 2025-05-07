package com.debuggers.factory;

import com.debuggers.domain.School;

public class SchoolFactory {
    public static School createSchool(Long id, String name, String address){
        if (id == null || name == null || name.isBlank() || address == null || address.isBlank()) {
            return null;
        }

        return new School.Builder()
                .setId(id)
                .setSchoolName(name)
                .setSchoolAddress(address)
                .build();
    }
}
