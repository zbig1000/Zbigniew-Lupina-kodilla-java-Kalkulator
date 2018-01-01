package com.kodilla.exception.test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteFinderTestSuiteTask {
    private RouteFinder routeFinder;

    @Test
    public void testRouteFinderFlightPossible() {

        boolean isFlightToBerlin = false;
        routeFinder = new RouteFinder();

        // Given
        Flight flightToBerlin = new Flight("Warsaw", "Berlin");

        // When
        try {
            isFlightToBerlin = routeFinder.findFlight(flightToBerlin);
        } catch (RouteNotFoundException e) {
        }

        // Then
        assertEquals(true, isFlightToBerlin);
    }

    @Test
    public void testRouteFinderFlightImpossible() {
        boolean isFlightToOttawa = true;
        RouteFinder routeFinder = new RouteFinder();

        // Given
        Flight flightToOttawa = new Flight("Warsaw", "Ottawa");

        // When
        try {
            isFlightToOttawa = routeFinder.findFlight(flightToOttawa);
        } catch (RouteNotFoundException e) {
        }

        // Then
        assertEquals(false, isFlightToOttawa);

    }

    @Test
    public void testRouteFinderFlightNotFound() {
        boolean isFlightToTokyo = true;
        RouteFinder routeFinder = new RouteFinder();

        // Given
        Flight flightToTokyo = new Flight("Warsaw", "Tokyo");

        // When
        try {
            isFlightToTokyo = routeFinder.findFlight(flightToTokyo);
        } catch (RouteNotFoundException e) {
            isFlightToTokyo = false;
        }

        // Then
        assertEquals(false, isFlightToTokyo);
    }
}
