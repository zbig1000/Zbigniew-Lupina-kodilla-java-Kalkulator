package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaExtraCheeseMushoomHamCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheesDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomDecorator(theOrder);
        //When
        BigDecimal calculateCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(25), calculateCost);
    }

    @Test
    public void testPizzaExtraCheeseMushroomHamDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheesDecorator(theOrder);
        theOrder = new HamDecorator(theOrder);
        theOrder = new MushroomDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza bootom + tomato souse + cheese + extra cheese + ham + mushrooms", description);
    }
    @Test
    public void testPizzaExtraCheeseMuschoomShimpsCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheesDecorator(theOrder);
        theOrder = new SchrimpsDecorator(theOrder);
        theOrder = new MushroomDecorator(theOrder);
        //When
        BigDecimal calculateCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(32), calculateCost);
    }

    @Test
    public void testPizzaExtraCheeseMuschoomShimpsDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new DoubleCheesDecorator(theOrder);
        theOrder = new SchrimpsDecorator(theOrder);
        theOrder = new MushroomDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza bootom + tomato souse + cheese + extra cheese + shrimps + mushrooms", description);
    }

}
