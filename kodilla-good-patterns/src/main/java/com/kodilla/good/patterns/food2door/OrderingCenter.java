package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderingCenter {
    private Map<String, VendorInterface> localvendorDB = new HashMap<>();
    private Map<Integer, DtoInterface> localOrderDB = new HashMap<>();

    public void addVendor(VendorInterface vendor) {
        localvendorDB.put(vendor.getVendorName(), vendor);
    }

    public List<ProductInterface> findProduct(String productName) {
        return localvendorDB.entrySet().stream()
                .map(entry -> entry.getValue().getProduct(productName))
                .collect(Collectors.toList());
    }

    public boolean processOrder(String productName, String vendorName, int quantity) {
        DtoInterface newDto;
        VendorInterface vendor = localvendorDB.get(vendorName);
        if (vendor == null) return false;
        ProductInterface product = vendor.getProduct(productName);
        if (product == null) return false;
        try {
            newDto = vendor.process(product, quantity);
            localOrderDB.put(newDto.getOrderNumber(), newDto);
            return true;
        } catch (NotSufficientStockException e) {
            System.out.println(e.getMessage() + " available stock " + e.getAvailableQuantity());
            return false;
        }
    }
    public int getTotalOrderNumber() {
        return localOrderDB.size();
    }
    public void listOrders() {
        localOrderDB.entrySet().stream()
                .map(entry -> entry.getValue().getOrderNumber())
                .forEach(System.out::println);
    }

}