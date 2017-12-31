package com.kodilla.good.patterns.food2door;

public class OrderingCenterTester {
    
    public static void main(String arg[]) {

        OrderingCenter orderingCenter = new OrderingCenter();
        
        Vendor vendorKanapki = new Vendor("Kanapki", "Bydgoszcz", 1);
        vendorKanapki.addProduct(new Product("sandwich", "sandwich", 3.3d, 1000));
        vendorKanapki.addProduct(new Product("Rollo", "sandwich", 5.2d, 500));
        vendorKanapki.addProduct(new Product("Tacos", "sandwich", 7.1d, 100));
        vendorKanapki.addProduct(new Product("Golden", "sandwich", 10.0d, 10));

        Vendor vendorNapoje = new Vendor("Napoje", "Warszawa", 2);
        vendorNapoje.addProduct(new Product("Cola", "drink", 2.0d, 1000));
        vendorNapoje.addProduct(new Product("Mineral Water", "drink", 1.0d, 1000));
        vendorNapoje.addProduct(new Product("Desperados", "beer", 1.0d, 1000));

        orderingCenter.addVendor(vendorKanapki);
        orderingCenter.addVendor(vendorNapoje);

        orderingCenter.processOrder("Rollo", "Kanapki", 3);
        orderingCenter.processOrder("Cola", "Napoje", 3);
        orderingCenter.processOrder("Golden", "Kanapki", 20);

        orderingCenter.processOrder("Rollo", "Kanapki", 3);
        orderingCenter.processOrder("Cola", "Napoje", 3);

        System.out.println("total order number " + orderingCenter.getTotalOrderNumber());
        orderingCenter.listOrders();

    }
}
