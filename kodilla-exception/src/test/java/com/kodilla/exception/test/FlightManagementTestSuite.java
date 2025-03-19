package com.kodilla.exception.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FlightManagementTestSuite {

    private FlightManagement flightManagement;
    private Map<String, Boolean> flights;

    @BeforeEach
    void setUp() {
        //Given
        flights = new HashMap<>();
        flights.put("A", true);
        flights.put("B", false);
        flights.put("C", false);
        flights.put("D", true);
        flightManagement = new FlightManagement(flights);
    }

    @Test
    public void shouldNotThrowExceptionWhenFlightExists() {
        //Given
        Flight flight = new Flight("A", "D");

        //When
        Flight result = assertDoesNotThrow(() -> flightManagement.findFlight(flight));

        //Then
        assertEquals(flight, result);
    }

    @Test
    public void shouldThrowExceptionWhenFlightDoesNotExist() {
        //Given
        Flight flight = new Flight("A", "E");

        //When & Then
        assertThrows(RouteNotFoundException.class, () -> flightManagement.findFlight(flight));
    }

    @Test
    public void shouldThrowExceptionWhenFlightExistsButWeCantLanded() {
        //Given
        Flight flight = new Flight("A", "B");
        //When & Then
        assertThrows(RouteNotFoundException.class, () -> flightManagement.findFlight(flight));
    }

}