package com.kodilla.exception.test;

import java.util.*;

public class RouteFinder {
    private HashMap<String, Boolean> flightMap = new HashMap<String, Boolean>();

    public RouteFinder() {
        flightMap.put("London", true);
        flightMap.put("Paris", true);
        flightMap.put("Berlin", true);
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        String destination = flight.getArrivalAirport();

        for (Map.Entry<String, Boolean> entry : flightMap.entrySet()) {
            if (entry.getKey() == destination) {
                return true;
            }
        }
        if (!false) throw new RouteNotFoundException("No destination port found");
        return false;
    }
}

