package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderingCenter {
    private Map<String, Vendor> localVendorDB = new HashMap<>();
    private Map<Integer, OrderDTO> localOrderDB = new HashMap<>();
    private int orderErrorCounter = 0;

    private int generateErrorOrderNumber() {
        orderErrorCounter++;
        return 99*1000000 + LocalDate.now().getDayOfYear()*1000 +orderErrorCounter;
    }

    public void addVendor(Vendor vendor) {
        localVendorDB.put(vendor.getVendorName(), vendor);
    }

    public List<Product> findProduct(String productName) {
        return localVendorDB.entrySet().stream()
                .map(entry -> entry.getValue().getProduct(productName))
                .collect(Collectors.toList());
    }

    private Vendor getVendor(String productName, String vendorName, int quantity) throws VendorNotFoundException{
        Vendor vendor = localVendorDB.get(vendorName);
        if (vendor == null) {
            int errorId = generateErrorOrderNumber();
            localOrderDB.put(errorId, new OrderDTOImpl(vendorName +"NOT found", productName, quantity, errorId, "rejected"));
            throw new VendorNotFoundException("Vendor " + vendorName + " NOT found") ;
        }
        return vendor;
    }

    private Product getProductFromVendor(String productName, Vendor vendor, int quantity) throws ProductNotFoundException {
        Product product = vendor.getProduct(productName);
        if (product == null) {
            int errorId = generateErrorOrderNumber();
            localOrderDB.put(errorId, new OrderDTOImpl(vendor.getVendorName(), productName + "NOT found", quantity, errorId, "rejected"));
            throw new ProductNotFoundException("Product " + productName + " NOT found in " + vendor.getVendorName());
        }
        return product;
    }

    public boolean processOrder(String productName, String vendorName, int quantity) throws VendorNotFoundException, ProductNotFoundException, NotSufficientStockException {
        OrderDTO newOrderDTO;
        try {
            Vendor vendor = getVendor(productName, vendorName, quantity);
            Product product = getProductFromVendor(productName, vendor, quantity);

            newOrderDTO = vendor.process(product, quantity);
            localOrderDB.put(newOrderDTO.getOrderNumber(), newOrderDTO);
            return true;

        } catch (NotSufficientStockException e) {
            int errorId = generateErrorOrderNumber();
            localOrderDB.put(errorId, new OrderDTOImpl(vendorName, productName + "NOT sufficient stock", quantity, errorId, "rejected"));
            throw new NotSufficientStockException("Product " + productName + " quantity " + quantity + " NOT sufficient in " + vendorName, e.getAvailableQuantity());
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