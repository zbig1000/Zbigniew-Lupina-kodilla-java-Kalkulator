package com.kodilla.good.patterns.aircompany;

import org.junit.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightFinderTestSuite {
    FlightFinder flightFinder;
    private FlightFinder createFlightFinder() {
        FlightFinder flightFinder = new FlightFinder();
        flightFinder.addFlight(new Flight(1, "Poznan", "Warszawa", LocalTime.of(0, 30), LocalTime.of(1, 50)));
        flightFinder.addFlight(new Flight(2, "Poznan", "Katowice", LocalTime.of(1, 30), LocalTime.of(2, 50)));
        flightFinder.addFlight(new Flight(3, "Poznan", "Bydgoszcz", LocalTime.of(2, 30), LocalTime.of(4, 50)));
        flightFinder.addFlight(new Flight(4, "Poznan", "Gdańsk", LocalTime.of(10, 30), LocalTime.of(12, 50)));

        flightFinder.addFlight(new Flight(5, "Warszawa", "Poznan", LocalTime.of(11, 30), LocalTime.of(14, 50)));
        flightFinder.addFlight(new Flight(6, "Katowice", "Poznan", LocalTime.of(12, 30), LocalTime.of(15, 50)));
        flightFinder.addFlight(new Flight(7, "Bydgoszcz", "Poznan", LocalTime.of(13, 30), LocalTime.of(16, 50)));
        flightFinder.addFlight(new Flight(8, "Gdańsk", "Poznan", LocalTime.of(14, 30), LocalTime.of(16, 50)));

        flightFinder.addFlight(new Flight(9, "Bydgoszcz", "Katowice", LocalTime.of(15, 30), LocalTime.of(17, 50)));
        flightFinder.addFlight(new Flight(10, "Katowice", "Bydgoszcz", LocalTime.of(16, 30), LocalTime.of(18, 50)));

        flightFinder.addFlight(new Flight(11, "Katowice", "Gdańsk", LocalTime.of(17, 30), LocalTime.of(19, 50)));
        flightFinder.addFlight(new Flight(12, "Gdańsk", "Katowice", LocalTime.of(18, 30), LocalTime.of(20, 50)));

        flightFinder.addFlight(new Flight(13, "Poznan", "Warszawa", LocalTime.of(20, 30), LocalTime.of(21, 50)));
        flightFinder.addFlight(new Flight(14, "Katowice", "Warszawa", LocalTime.of(22, 30), LocalTime.of(23, 50)));

        flightFinder.addFlight(new Flight(15, "Bydgoszcz", "Poznan", LocalTime.of(17, 15), LocalTime.of(18, 55)));
        flightFinder.addFlight(new Flight(16, "Poznan", "Warszawa", LocalTime.of(11, 15), LocalTime.of(14, 15)));
        return flightFinder;
    }

    @Test
    public void getCrossFlightFromThroughToTest() {
        // Given
        FlightFinder flightFinder = createFlightFinder();

        // When
        List<Connection> connectionList =  flightFinder.getCrossFlightFromThroughTo("Bydgoszcz", "Poznan", "Warszawa");

        // Then
        int availableConnections = connectionList.size();
        assertEquals(6, availableConnections);
    }

    @Test
    public void getTotalCrossFlightTest() {
        // Given
        FlightFinder flightFinder = createFlightFinder();

        // When
        List<Connection> connectionList =  flightFinder.getCrossFlightFromTo("Bydgoszcz", "Warszawa");

        // Then
        int availableConnections = connectionList.size();
        assertEquals(7, availableConnections);
    }

}
