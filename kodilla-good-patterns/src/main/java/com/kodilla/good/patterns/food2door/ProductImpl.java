package com.kodilla.good.patterns.food2door;

public class ProductImpl implements Product {
    private String productName;
    private String productType;
    private double productPrice;
    private int productAvailableQuantity;

    public ProductImpl(String productName, String productType, double productPrice, int productAvailableQuantity) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productAvailableQuantity = productAvailableQuantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public int getProductAvailableQuantity() {
        return productAvailableQuantity;
    }
}
