package com.kodilla.exception.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RouteFinderTestSuiteTask {

    @Test
    public void testRouteFinder() {

        boolean isFlightToBerlin, isFlightToTokyo, isFlightToParis;
        RouteFinder routeFinder = new RouteFinder();

        // Given
        Flight flightToBerlin = new Flight("Warsaw", "Berlin");
        Flight flightToTokyo = new Flight("Warsaw", "Tokyo");
        Flight flightToParis = new Flight("Warsaw", "Paris");

        // When
        try {
            isFlightToBerlin = routeFinder.findFlight(flightToBerlin);
        } catch (RouteNotFoundException e) {
            isFlightToBerlin = false;
        }
        try {
            isFlightToTokyo = routeFinder.findFlight(flightToTokyo);
        } catch (RouteNotFoundException e) {
            isFlightToTokyo = false;
        }
        try {
            isFlightToParis = routeFinder.findFlight(flightToParis);
        } catch (RouteNotFoundException e) {
            isFlightToParis = false;
        }

        // Then
        assertEquals(true, isFlightToBerlin);
        assertEquals(false, isFlightToTokyo);
        assertEquals(true, isFlightToParis);
    }
}
