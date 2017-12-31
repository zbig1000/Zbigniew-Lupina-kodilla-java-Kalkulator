package com.kodilla.good.patterns.food2door;

public class NotSufficientStockException extends Exception {
    private int availableQuantity;
    public NotSufficientStockException(String message, int quantity) {
        super(message);
        availableQuantity = quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
