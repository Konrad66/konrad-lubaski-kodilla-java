package com.kodilla.exception.test;

import java.util.Map;

public class FlightManagement {

    Map<String, Boolean> flights;

    public FlightManagement(Map<String, Boolean> flights) {
        this.flights = flights;
    }

    public Flight findFlight(Flight flight) throws RouteNotFoundException {
        if (flights.containsKey(flight.getArrivalAirport())) {
            if (flights.get(flight.getArrivalAirport())) {
                return flight;
            } else {
                throw new RouteNotFoundException("You can't fly to this airport");
            }
        } else {
            throw new RouteNotFoundException("Airport not found");
        }
    }
}