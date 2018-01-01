package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface Vendor {

    OrderDTO process(Product prod, int quantity) throws NotSufficientStockException;

    List<Product> getProductList();

    Product getProduct(String productName);

    String getVendorName();

    String getVendorAddress();
}
