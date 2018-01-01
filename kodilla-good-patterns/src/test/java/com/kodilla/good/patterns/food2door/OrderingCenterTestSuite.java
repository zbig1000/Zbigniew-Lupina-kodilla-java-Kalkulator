package com.kodilla.good.patterns.food2door;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderingCenterTestSuite {
    OrderingCenter orderingCenter;
    VendorImpl vendorImplKanapki;
    VendorAlternativeImpl vendorAlternativeImplNapoje;

    private void prepareData() {
        orderingCenter = new OrderingCenter();

        vendorImplKanapki = new VendorImpl("Kanapki", "Bydgoszcz", 1);
        vendorImplKanapki.addProduct(new ProductImpl("sandwich", "sandwich", 3.3d, 1000));
        vendorImplKanapki.addProduct(new ProductImpl("Rollo", "sandwich", 5.2d, 500));
        vendorImplKanapki.addProduct(new ProductImpl("Tacos", "sandwich", 7.1d, 100));
        vendorImplKanapki.addProduct(new ProductImpl("Golden", "sandwich", 10.0d, 10));

        vendorAlternativeImplNapoje = new VendorAlternativeImpl("Napoje", "Warszawa", 2);
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Cola", "drink", 2.0d, 1000));
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Mineral Water", "drink", 1.0d, 1000));
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Desperados", "beer", 1.0d, 1000));

        orderingCenter.addVendor(vendorImplKanapki);
        orderingCenter.addVendor(vendorAlternativeImplNapoje);
    }

    @Test
    public void testTotalOrderNumber() {
        // Given
        prepareData();
        ServiceUser serviceUser = new ServiceUser(orderingCenter);
        // When

        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Cola", "Napoje", 3);
        // order to be rejected
        serviceUser.putOrder("Golden", "Kanapki", 20);

        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Cola", "Napoje", 3);

        // Then
        int totalOrderNumber = orderingCenter.getTotalOrderNumber();
        assertEquals(5, totalOrderNumber);
    }

    @Test
    public void isVendorStockUpdated() {
        // Given
        prepareData();
        ServiceUser serviceUser = new ServiceUser(orderingCenter);

        // When
        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Cola", "Napoje", 3);
        // order to be rejected
        serviceUser.putOrder("Golden", "Kanapki", 20);

        serviceUser.putOrder("Golden", "Kanapki", 8);
        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Desperados", "Napoje", 3);

        Product product = vendorImplKanapki.getProduct("Golden");
        int availableStockforKanapkiGolden = product.getProductAvailableQuantity();

        // Then
        assertEquals(2, availableStockforKanapkiGolden);
    }

}
