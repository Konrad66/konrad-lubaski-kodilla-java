package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuite {

    @Test
    void testEdgeCases() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.5, 1.5)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.9, 0.0)),
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0, 0.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.0, 0.0)),
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.999, 2.0))
        );
    }

}