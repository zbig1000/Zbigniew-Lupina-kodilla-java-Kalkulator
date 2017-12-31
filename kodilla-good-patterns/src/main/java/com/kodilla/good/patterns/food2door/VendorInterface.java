package com.kodilla.good.patterns.food2door;

import java.util.List;

public interface VendorInterface {

    DtoInterface process(ProductInterface prod, int quantity) throws NotSufficientStockException;

    List<ProductInterface> getProductList();

    ProductInterface getProduct(String productName);

    String getVendorName();

    String getVendorAddress();
}
