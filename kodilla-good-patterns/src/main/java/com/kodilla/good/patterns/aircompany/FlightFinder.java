package com.kodilla.good.patterns.aircompany;

import java.util.*;
import java.util.stream.Collectors;

public class FlightFinder {
    private Map<Integer, Flight> flightMapDB = new HashMap<>();

    public void addFlight(Flight flight) {
        flightMapDB.put(flight.getFlightNumber(), flight);
    }

    public List<Flight> getDirectFlightTo(String arrivalPort) {
        return flightMapDB.entrySet().stream().parallel()
                .map(entry -> entry.getValue())
                .filter(entry -> entry.getArrivalPort().equals(arrivalPort))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlightFrom(String departurePort) {
        return flightMapDB.entrySet().stream().parallel()
                .map(entry -> entry.getValue())
                .filter(entry -> entry.getDeparturePort().equals(departurePort))
                .collect(Collectors.toList());
    }

    // EXTRA METHOD - automatic finding
    public List<Connection> getCrossFlightFromTo(String departurePort, String arrivalPort) {
        return collectIntermediateFlightTables(getFlightFrom(departurePort)).stream()
                .flatMap(linkTable -> linkTable.getConnectionTo(arrivalPort).stream())
                .collect(Collectors.toList());
    }

    // EXTRA METHOD - automatic finding
    private Set<LinkTable> collectIntermediateFlightTables(List<Flight> flightList) {
        Set<LinkTable> intermediatePortDB = new HashSet<>();
        for (Flight flight : flightList) {
            intermediatePortDB.add(new LinkTable(getFlightFrom(flight.getArrivalPort()), flight));
        }
        return intermediatePortDB;
    }

    public List<Connection> getCrossFlightFromThroughTo(String departurePort, String itermediatePort, String arrivalPort) {

        List<Flight> intermediateFlights = getFlightFrom(departurePort).stream()
                .filter(flight -> flight.getArrivalPort().equals(itermediatePort))
                .collect(Collectors.toList());

        List<Flight> endFlights = getFlightFrom(itermediatePort).stream()
                .filter(flight -> flight.getArrivalPort().equals(arrivalPort))
                .collect(Collectors.toList());

        List<Connection> connectionList = new LinkedList<>();
        for (Flight flight: endFlights)
        {
            Connection connection;
            for (Flight nextFlight: intermediateFlights) {
                connection = new Connection(flight);
                connection.addFlightToConnection(nextFlight);
                connectionList.add(connection);
            }
        }
        return connectionList;
    }

}
