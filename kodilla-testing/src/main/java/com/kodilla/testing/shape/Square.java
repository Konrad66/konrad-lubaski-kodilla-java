package com.kodilla.testing.shape;

public class Square implements Shape {

    private int x;

    public Square(int x) {
        this.x = x;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return x * x;
    }

    @Override
    public String toString() {
        return "square";
    }
}
