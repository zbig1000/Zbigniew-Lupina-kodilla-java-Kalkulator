package com.kodilla.good.patterns.food2door;

public class OrderDTOImpl implements OrderDTO {
    private String vendorName;
    private String productName;
    private int quantity;
    private int orderNumber;
    private String status;

    public OrderDTOImpl(String vendorName, String productName, int quantity, int orderNumber, String status) {
        this.vendorName = vendorName;
        this.productName = productName;
        this.quantity = quantity;
        this.orderNumber = orderNumber;
        this.status = status;
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

    @Override
    public String getStatus() {
        return status;
    }
}

