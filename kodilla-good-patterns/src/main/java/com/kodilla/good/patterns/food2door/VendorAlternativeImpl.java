package com.kodilla.good.patterns.food2door;

public class VendorAlternativeImpl extends  VendorImpl {

    @Override
    protected int generateOrderNumber() {
        orderNumber++;
        return vendorId*1000000 + orderNumber;
    }

    public VendorAlternativeImpl(String vendorName, String vendorAddress, int vendorId) {
        super(vendorName, vendorAddress, vendorId);
    }
}

