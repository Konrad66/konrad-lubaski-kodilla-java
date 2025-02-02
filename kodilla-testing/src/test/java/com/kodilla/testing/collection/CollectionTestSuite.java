package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionTestSuite {

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test begun");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each test end");
    }



    @DisplayName(
            "Given an empty List " +
                    "when exterminate() is called " +
                    "then it should return an empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(emptyList);

        //Then
        assertTrue(result.isEmpty());
    }


    @DisplayName(
            "Given list with only even numbers " +
                    "when exterminate() is called " +
                    "then it should return the same list"
    )
    @Test
    void testOddNumbersExterminatorEvenList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> evenNumberList = Arrays.asList(0, 2, 4, 6, 8);

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(evenNumberList);

        //Then
        assertEquals(evenNumberList, result);
    }

    @DisplayName(
            "Given list with normal numbers " +
                    "when exterminate() is called " +
                    "then it should return the list with even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> numberList = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> expectedList = Arrays.asList(0, 2, 4, 6, 8);

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(numberList);

        //Then
        assertEquals(expectedList, result);
    }
}