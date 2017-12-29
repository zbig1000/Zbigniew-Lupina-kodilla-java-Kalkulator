package com.kodilla.exception.test;

public class RouteProcessor {
    public static void main(String args[]) {
        boolean isFlight;
        RouteFinder routeFinder = new RouteFinder();

        Flight flight1 = new Flight("Warsaw", "Berlin");
        Flight flight2 = new Flight("Warsaw", "Tokyo");
        Flight flight3 = new Flight("Warsaw", "Paris");

        try {
            if (routeFinder.findFlight(flight1))
                System.out.println("Flight to " + flight1.getArrivalAirport() + " found");
        } catch (RouteNotFoundException e) {
            System.out.println("No flight to " + flight1.getArrivalAirport());
        }
        try {
            if (routeFinder.findFlight(flight2))
                System.out.println("Flight to " + flight2.getArrivalAirport() + " found");
        } catch (RouteNotFoundException e) {
            System.out.println("No flight to " + flight2.getArrivalAirport());
        }
        try {
            if (routeFinder.findFlight(flight3))
                System.out.println("Flight to " + flight3.getArrivalAirport() + " found");
        } catch (RouteNotFoundException e) {
            System.out.println("No flight to " + flight3.getArrivalAirport());
        }
    }
}
