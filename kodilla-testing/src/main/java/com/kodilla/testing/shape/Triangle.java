package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double base;
    private double hight;

    public Triangle(double base, double hight) {
        this.base = base;
        this.hight = hight;
    }

    public String getShapeName() { return "Triangle" ;}

    public double getField() {
        return 0.5*base*hight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Triangle) return true;
        else return false;    }
}
