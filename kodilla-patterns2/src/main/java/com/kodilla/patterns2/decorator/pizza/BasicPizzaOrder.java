package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public String getDescription() {
        return "Pizza bootom + tomato souse + cheese" ;
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(15);
    }
}
