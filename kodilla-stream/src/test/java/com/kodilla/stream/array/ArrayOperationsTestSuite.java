package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //When
        double averageResult = ArrayOperations.getAverage(numbers);

        //Then
        assertEquals(5.5, averageResult, 0.01);
    }
}
