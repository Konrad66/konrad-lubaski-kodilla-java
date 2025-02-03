package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    void addShape(Shape shape) {
        shapes.add(shape);
    }

    void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    Shape getShape(int n) {
        return shapes.get(n);
    }

    String showFigure() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shapes.size(); i++) {
            if (i != shapes.size() - 1) {
                sb.append(shapes.get(i).toString() + ", ");
            } else {
                sb.append(shapes.get(i).toString());
            }
        }
        return sb.toString();
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}