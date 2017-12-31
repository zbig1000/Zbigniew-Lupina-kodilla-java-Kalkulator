package com.kodilla.good.patterns.food2door;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Vendor implements VendorInterface {
    private String vendorName;
    private String vendorAddress;
    private int orderNumber = 0;
    private int vendorId;
    Map<String, ProductInterface> productWarehouse = new HashMap<>();

    private int generateOrderNumber() {
        orderNumber++;
        return vendorId*1000000 + LocalDate.now().getDayOfYear()*1000 +orderNumber;
    }


    public Vendor(String vendorName, String vendorAddress, int vendorId) {
        this.vendorName = vendorName;
        this.vendorAddress = vendorAddress;
        this.vendorId = vendorId;
    }

    public void addProduct(ProductInterface prod) {
        productWarehouse.put(prod.getProductName(), prod);
    }

    @Override
    public DtoInterface process(ProductInterface prod, int quantity) throws NotSufficientStockException {

        int newQuantity = productWarehouse.get(prod.getProductName()).getProductAvailableQuantity();
        if (newQuantity >= quantity) {
            newQuantity -= quantity;
            productWarehouse.put(prod.getProductName(), new Product(prod.getProductName(), prod.getProductType(), prod.getProductPrice(), newQuantity));

            return new Dto(vendorName, prod.getProductName(), quantity, generateOrderNumber());
        } else throw new NotSufficientStockException("Not sufficient stock now, try available stock", newQuantity);
    }

    @Override
    public List<ProductInterface> getProductList() {
        return productWarehouse.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public ProductInterface getProduct(String productName) {
        return productWarehouse.get(productName);
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }
}
