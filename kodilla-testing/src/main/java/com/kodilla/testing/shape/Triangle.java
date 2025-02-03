package com.kodilla.testing.shape;

import java.awt.*;

public class Triangle implements Shape {

    private int a;
    private int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (double) (a * h) / 2;
    }

    @Override
    public String toString() {
        return "triangle";
    }
}
