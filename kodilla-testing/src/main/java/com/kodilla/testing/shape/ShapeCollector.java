package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {

    private ArrayList<Shape> arrayShapes;
    public ShapeCollector() {
        arrayShapes = new ArrayList<Shape>();
    }

    public void addFigure(Shape shape) {
        arrayShapes.add(shape);
    }
    public void removeFigure(Shape shape) {
        for (Shape sh: arrayShapes) {
            String shapeName = sh.getShapeName();
            if (shapeName == shape.getShapeName()) {
                arrayShapes.remove(sh);
                break;
            }

        }
    }
    public Shape getFigure(int n) {
        return arrayShapes.get(n);
    }
    public String showFigures() {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Shape sh: arrayShapes) {
            stringBuilder.append(sh.getShapeName());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
    public int getSize() {
        return arrayShapes.size();
    }

}
