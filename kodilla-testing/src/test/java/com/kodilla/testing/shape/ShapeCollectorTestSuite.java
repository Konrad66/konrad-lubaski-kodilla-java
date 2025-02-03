package com.kodilla.testing.shape;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Shape Test Suite")
class ShapeCollectorTestSuite {

    @Nested
    @DisplayName("Tests for circles")
    class TestsCircles {

        private ShapeCollector shapeCollector;
        private Circle circle;

        @BeforeEach
        void setUp() {
            //Given
            shapeCollector = new ShapeCollector();
            circle = new Circle(2);
        }

        @Test
        void testAddCircleToShapes() {
            //Given

            //When
            shapeCollector.addShape(circle);

            //Then
            assertEquals(1, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveCircleFromShapes() {
            //Given

            //When
            shapeCollector.addShape(circle);
            shapeCollector.removeShape(circle);

            //Then
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testGetCircleFromShapes() {
            //Given

            //When
            shapeCollector.addShape(circle);
            Shape result = shapeCollector.getShape(0);

            //Then
            assertEquals(circle, result);
        }

        @Test
        void testShowFigures() {
            //Given
            Circle circle2 = new Circle(2);
            Circle circle3 = new Circle(2);

            //When
            shapeCollector.addShape(circle);
            shapeCollector.addShape(circle2);
            shapeCollector.addShape(circle3);
            String result = shapeCollector.showFigure();

            //Then
            assertEquals("circle, circle, circle", result);
        }


    }

    @Nested
    @DisplayName("Tests for squares")
    class TestsSquares {

        private ShapeCollector shapeCollector;
        private Square square;

        @BeforeEach
        void setUp() {
            //Given
            shapeCollector = new ShapeCollector();
            square = new Square(4);
        }

        @Test
        void testAddSquareToShapes() {
            //Given

            //When
            shapeCollector.addShape(square);

            //Then
            assertEquals(1, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveSquareFromShapes() {
            //Given

            //When
            shapeCollector.addShape(square);
            shapeCollector.removeShape(square);

            //Then
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testGetSquareFromShapes() {
            //Given

            //When
            shapeCollector.addShape(square);
            Shape result = shapeCollector.getShape(0);

            //Then
            assertEquals(square, result);
        }

        @Test
        void testShowFigures() {
            //Given

            //When
            Square square2 = new Square(4);
            shapeCollector.addShape(square);
            shapeCollector.addShape(square2);
            String result = shapeCollector.showFigure();

            //Then
            assertEquals("square, square", result);
        }
    }

    @Nested
    @DisplayName("Tests for triangles")
    class TestsTriangles {

        private ShapeCollector shapeCollector;
        private Triangle triangle;

        @BeforeEach
        void setUp() {
            shapeCollector = new ShapeCollector();
            triangle = new Triangle(4, 5);
        }

        @Test
        void testAddTriangleToShapes() {
            //Given

            //When
            shapeCollector.addShape(triangle);

            //Then
            assertEquals(1, shapeCollector.getShapes().size());
        }

        @Test
        void testRemoveTriangleFromShapes() {
            //Given

            //When
            shapeCollector.addShape(triangle);
            shapeCollector.removeShape(triangle);

            //Then
            assertEquals(0, shapeCollector.getShapes().size());
        }

        @Test
        void testGetTriangleFromShapes() {
            //Given

            //When
            shapeCollector.addShape(triangle);
            Shape result = shapeCollector.getShape(0);

            //Then
            assertEquals(triangle, result);
        }

        @Test
        void testShowFigures() {
            //Given

            //When
            Triangle triangle2 = new Triangle(4, 5);
            shapeCollector.addShape(triangle);
            shapeCollector.addShape(triangle2);
            String result = shapeCollector.showFigure();

            //Then
            assertEquals("triangle, triangle", result);
        }
    }
}