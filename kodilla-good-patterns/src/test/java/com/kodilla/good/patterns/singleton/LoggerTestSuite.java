package com.kodilla.good.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    private static Logger logger;

    @BeforeAll
    static void setUp() {
        logger = Logger.INSTANCE;
        logger.log("Hello World");
    }

    @Test
    void testLogger() {
        //Given
        //When
        logger.log("Bye World");

        //Then
        assertEquals("Bye World", logger.getLastLog());
    }
}