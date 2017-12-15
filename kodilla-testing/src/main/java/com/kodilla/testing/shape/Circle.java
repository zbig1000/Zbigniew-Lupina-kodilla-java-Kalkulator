package com.kodilla.testing.shape;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() { return "Circle" ;}

    public double getField() {
        return PI*pow(radius, 2d);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) return true;
        else return false;
    }
}
