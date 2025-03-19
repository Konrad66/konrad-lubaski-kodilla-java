package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightRunner {

    public static void main(String[] args) {
        Map<String, Boolean> flights = new HashMap<>();

        flights.put("A", true);
        flights.put("B", false);
        flights.put("C", false);
        flights.put("D", true);

        FlightManagement flightManagement = new FlightManagement(flights);
        try {
            Flight flight = new Flight("A", "B");
            flightManagement.findFlight(flight);

        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Flight flight2 = new Flight("C", "D");
            flightManagement.findFlight(flight2);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
