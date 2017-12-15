package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {

    @Test
    public void testAddingFigure() {
       //Given
       ShapeCollector sc = new ShapeCollector();
       Circle circle = new Circle(2d);
       //When
       sc.addFigure(circle);
       //Then
       Assert.assertEquals(sc.getFigure(0), circle);
    }

    @Test
    public void testRemovingFigure() {
        //Given
        ShapeCollector sc = new ShapeCollector();
        Circle circle = new Circle(2d);
        //When
        sc.addFigure(circle);
        sc.removeFigure(circle);
        //Then
        Assert.assertEquals(sc.getSize(), 0);
    }
    @Test
    public void testShowingFigure() {
        //Given
        ShapeCollector sc = new ShapeCollector();
        Circle circle = new Circle(2d);
        Square square = new Square(2d);

        //When
        sc.addFigure(circle);
        sc.addFigure(square);
        // Then
        Assert.assertEquals(sc.showFigures(), "Circle Square");
    }
}
