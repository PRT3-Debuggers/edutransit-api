package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.domain.Parent;
import com.debuggers.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentFactoryTest {

    private static User driverGazly = UserFactory.createUser(
            null,
            "Pierre",
            "Gazly",
            "gazly@gmail.com",
            "Gazly$06"
    );

    // Create a Parent using ParentFactory
    private static Parent parent = ParentFactory.createUser(null, driverGazly);



    @Test
    void createUser() {
        assertNotNull(parent);
        System.out.println("Parent created: " + parent);
    }


}