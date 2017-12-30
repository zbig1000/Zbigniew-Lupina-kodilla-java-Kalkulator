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

        if (!flightMap.containsKey(flight.getArrivalAirport()))
            throw new RouteNotFoundException("No destination port found");
        return true;
    }
}

