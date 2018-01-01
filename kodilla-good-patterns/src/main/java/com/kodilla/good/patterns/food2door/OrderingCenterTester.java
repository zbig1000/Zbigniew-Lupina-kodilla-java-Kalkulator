package com.kodilla.good.patterns.food2door;

public class OrderingCenterTester {
    OrderingCenter orderingCenter;



    public static void main(String arg[]) {

        OrderingCenter orderingCenter = new OrderingCenter();
        
        VendorImpl vendorImplKanapki = new VendorImpl("Kanapki", "Bydgoszcz", 1);
        vendorImplKanapki.addProduct(new ProductImpl("sandwich", "sandwich", 3.3d, 1000));
        vendorImplKanapki.addProduct(new ProductImpl("Rollo", "sandwich", 5.2d, 500));
        vendorImplKanapki.addProduct(new ProductImpl("Tacos", "sandwich", 7.1d, 100));
        vendorImplKanapki.addProduct(new ProductImpl("Golden", "sandwich", 10.0d, 10));

        VendorAlternativeImpl vendorAlternativeImplNapoje = new VendorAlternativeImpl("Napoje", "Warszawa", 2);
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Cola", "drink", 2.0d, 1000));
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Mineral Water", "drink", 1.0d, 1000));
        vendorAlternativeImplNapoje.addProduct(new ProductImpl("Desperados", "beer", 1.0d, 1000));

        orderingCenter.addVendor(vendorImplKanapki);
        orderingCenter.addVendor(vendorAlternativeImplNapoje);

        ServiceUser serviceUser = new ServiceUser(orderingCenter);
        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Cola", "Napoje", 3);

        serviceUser.putOrder("Golden", "Kanapki", 20);
        serviceUser.putOrder("Golden", "Kanapki", 8);

        serviceUser.putOrder("Rollo", "Kanapki", 3);
        serviceUser.putOrder("Cola", "Napoje", 3);

        System.out.println("total order number " + orderingCenter.getTotalOrderNumber());
        orderingCenter.listOrders();

    }
}
