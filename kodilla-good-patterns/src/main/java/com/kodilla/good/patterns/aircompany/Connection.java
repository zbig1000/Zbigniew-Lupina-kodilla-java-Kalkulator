package com.kodilla.good.patterns.aircompany;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Connection {
    private List<Flight> flightList = new LinkedList<>();

    public Connection(Flight flight) {
        flightList.add(flight);
    }

    public void addFlightToConnection(Flight flight) {
        flightList.add(0, flight);
    }

    @Override
    public String toString() {
        return flightList.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" --> ", "<< ", ">>"));
    }
}
