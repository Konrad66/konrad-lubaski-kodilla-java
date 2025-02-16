package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.println(numbers[i]));

        //return numbers.length == 0 ? 0 : (double) IntStream.of(numbers).sum() / numbers.length;
        return IntStream.of(numbers).average().orElse(0.0);
    }
}