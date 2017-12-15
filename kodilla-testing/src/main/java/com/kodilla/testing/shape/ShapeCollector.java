package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ShapeCollector {

    private ArrayList<Shape> arrayShapes;
    public ShapeCollector() {
        arrayShapes = new ArrayList<Shape>();
    }

    public void addFigure(Shape shape) {
        arrayShapes.add(shape);
    }
    public void removeFigure(Shape shape) {
        arrayShapes.remove(shape);
    }
    public Shape getFigure(int n) {
        return arrayShapes.get(n);
    }
    public String showFigures() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (Shape sh: arrayShapes) {
            stringJoiner.add(sh.getShapeName());
        }
        return stringJoiner.toString();
    }
    public int getSize() {
        return arrayShapes.size();
    }

}
