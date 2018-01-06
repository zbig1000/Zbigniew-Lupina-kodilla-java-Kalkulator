package com.kodilla.good.patterns.food2door;

public class ServiceUser {
    private OrderingCenter oc;

    public ServiceUser(OrderingCenter oc) {
        this.oc = oc;
    }

    public void putOrder(String productName, String vendorName, int quantity) {
        try {
            oc.processOrder(productName, vendorName, quantity);
        } catch (VendorNotFoundException | ProductNotFoundException | NotSufficientStockException e) {
            System.out.println(e);
        }
    }
}

