package com.debuggers.factory;
/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.Util.helper;
import com.debuggers.domain.Driver;

public class DriverFactory {

    // Generate an internal driver ID if needed
    public static Long createUserId() {
        return helper.generateId(); // ✅ Create a new method that returns a random long
    }

    public static Driver createDriver(
            String criminalRecord,
            String maxPassengers,
            String availableSeats
    ) {
        // Validate input
        if (
                helper.isEmptyOrNullString(criminalRecord) ||
                helper.isEmptyOrNullString(maxPassengers) ||
                helper.isEmptyOrNullString(availableSeats)) {
            return null;
        }

        // Build and return the Driver
        return new Driver.Builder()
                .setCriminalRecord(criminalRecord)
                .setMaxPassengers(maxPassengers)
                .setAvailableSeats(availableSeats)
                .build();
    }
}