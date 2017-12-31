package com.kodilla.good.patterns.food2door;

public class Dto implements DtoInterface {
    private String vendorName;
    private String productName;
    private int quantity;
    private int orderNumber;

    public Dto(String vendorName, String productName, int quantity, int orderNumber) {
        this.vendorName = vendorName;
        this.productName = productName;
        this.quantity = quantity;
        this.orderNumber = orderNumber;
    }

    @Override
    public String getVendorName() {
        return vendorName;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getOrderNumber() {
        return orderNumber;
    }
}

