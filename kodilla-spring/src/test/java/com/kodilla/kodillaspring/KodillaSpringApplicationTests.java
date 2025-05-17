package com.kodilla.kodillaspring;

import com.kodilla.spring.shape.Circle;
import com.kodilla.spring.shape.Shape;
import com.kodilla.spring.shape.Square;
import com.kodilla.spring.shape.Triangle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KodillaSpringApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testCircleLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("circle");

        //When
        String shapeName = shape.getShapeName();

        //Then
        assertEquals("This is a circle.", shapeName);
    }

    @Test
    void testTriangleLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("triangle");

        //When
        String shapeName = shape.getShapeName();

        //Then
        assertEquals("This is a triangle.", shapeName);
    }

    @Test
    void testSquareLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("createSquare");

        //When
        String shapeName = shape.getShapeName();

        //Then
        assertEquals("This is a square.", shapeName);
    }

    @Test
    void testShapeLoadedIntoContainer() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Shape shape = (Shape) context.getBean("chosenShape");

        //When
        String shapeName = shape.getShapeName();

        //Given
        System.out.println("Chosen shape: " + shapeName);
    }

}