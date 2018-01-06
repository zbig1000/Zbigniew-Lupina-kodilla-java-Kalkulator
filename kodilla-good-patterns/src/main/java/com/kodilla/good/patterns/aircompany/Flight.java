package com.kodilla.good.patterns.aircompany;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    private final int flightNumber;
    private final String departurePort;
    private final String arrivalPort;
    private final LocalTime departTime;
    private final LocalTime arrivalTime;

    public Flight(int flightNumber, String departurePort, String arrivalPort, LocalTime departTime, LocalTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber +
                ", dep. " + departurePort + '\'' +
                ", arr. " + arrivalPort + '\'' +
                ", depTime=" + departTime +
                ", arrTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightNumber == flight.flightNumber;
    }

    @Override
    public int hashCode() {
        return flightNumber/100;
    }
}
