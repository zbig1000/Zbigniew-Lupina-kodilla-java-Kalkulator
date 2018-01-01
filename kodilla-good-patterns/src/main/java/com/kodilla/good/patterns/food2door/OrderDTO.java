package com.kodilla.good.patterns.food2door;

public interface OrderDTO {
    String getVendorName();

    String getProductName();

    int getQuantity();

    int getOrderNumber();

    String getStatus();
}
