package com.debuggers.factory;

import com.debuggers.domain.Driver;
import com.debuggers.domain.User;

public class DriverFactory {
    public static Driver createDriver(
            Long id,
            User user,
            String criminalRecord,
            String maxPassengers,
            String availableSeats
    ) {

        if (
                id.equals(null) || user.equals(null) || criminalRecord.equals(null) || maxPassengers.equals(null) || availableSeats.equals(null)
        ) {
            return null;
        }
        return new Driver.Builder()
                .setId(id)
                .setUser(user)
                .setCriminalRecord(criminalRecord)
                .setMaxPassengers(maxPassengers)
                .setAvailableSeats(availableSeats)
                .build();
    }
}