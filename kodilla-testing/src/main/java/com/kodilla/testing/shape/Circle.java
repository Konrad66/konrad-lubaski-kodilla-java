package com.kodilla.testing.shape;

public class Circle implements Shape {

    private double pi = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return pi * radius * radius;
    }

    @Override
    public String toString() {
        return "circle";
    }
}
