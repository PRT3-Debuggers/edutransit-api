package com.debuggers.factory;

/*

     Author: Bonga Velem (220052379)

    */
import com.debuggers.util.Helper;
import com.debuggers.domain.Driver;

public class DriverFactory {

    public static Driver createDriver(
            String criminalRecord,
            String maxPassengers,
            String availableSeats) {
        // Validate input
        if (Helper.IsEmptyOrNullString(criminalRecord) ||
                Helper.IsEmptyOrNullString(maxPassengers) ||
                Helper.IsEmptyOrNullString(availableSeats)) {
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