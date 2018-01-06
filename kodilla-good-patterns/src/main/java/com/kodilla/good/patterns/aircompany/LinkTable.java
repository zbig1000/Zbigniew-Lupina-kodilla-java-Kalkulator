package com.kodilla.good.patterns.aircompany;

import java.util.*;
import java.util.stream.Collectors;

public class LinkTable {
    private List<Flight> outFlightList = new LinkedList<>();
    private Flight inFlight;

    public LinkTable(List<Flight> flightList, Flight flight) {
        this.outFlightList = flightList;
        this.inFlight = flight;
    }

    public List<Connection> getConnectionTo(String arrivalPort) {
        List<Connection> connectionList = outFlightList.stream()
                .filter(flight -> flight.getArrivalPort() == arrivalPort)
                .map(flight -> new Connection(flight))
                .collect(Collectors.toList());
        connectionList.stream()
                .forEach(connection -> connection.addFlightToConnection(inFlight));
        return connectionList;
    }

    @Override
    public String toString() {
        return "LinkTable " + outFlightList.stream()
                .map(flight -> flight.toString())
                .collect(Collectors.joining(" * ", "<<", ">>"));
    }

}
