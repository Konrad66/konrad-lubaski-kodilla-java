package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given
        World earth = new World();
        Continent europe = new Continent();
        Continent america = new Continent();
        Continent africa = new Continent();
        america.addCountry(new Country(new BigDecimal("99999999901234567890")));
        africa.addCountry(new Country(new BigDecimal("98765432101234567890")));
        europe.addCountry(new Country(new BigDecimal("12345678901234567890")));
        earth.addContinent(europe);
        earth.addContinent(africa);
        earth.addContinent(america);

        //When
        BigDecimal peopleQuantity = earth.getPeopleQuantity();

        //Then
        BigDecimal expectedCountry = new BigDecimal("211111110903703703670");
        assertEquals(expectedCountry, peopleQuantity);
    }

}