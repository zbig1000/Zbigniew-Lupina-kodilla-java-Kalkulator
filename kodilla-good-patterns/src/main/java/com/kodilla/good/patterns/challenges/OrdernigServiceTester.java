package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrdernigServiceTester {
    private static int dailyOrderCounter = 0;

    public static int generateOrderKey() {
        dailyOrderCounter++;
        return LocalDate.now().getDayOfYear() * 1000 + dailyOrderCounter;
    }

    public static void main(String ards[]) {
        User userBydgoszcz = new User("Jan Kowalski", "Bydgoszcz");
        User userWarszawa = new User("Antoni Brzechwa", "Warszawa");

        Product szczotka = new Product("szczotka");
        Product kapcie = new Product("kapcie");
        Product miska = new Product("miska");

        OrderRequest orderRequestBydgoszczSzczotka = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(10), szczotka, 2, new OrderKey(generateOrderKey()));
        OrderRequest orderRequestBydgoszczKapcie = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(5), kapcie, 1, new OrderKey(generateOrderKey()));
        OrderRequest orderRequestWarszawaMiska = new OrderRequest(userWarszawa, LocalDate.now(), miska, 1, new OrderKey(generateOrderKey()));

        ProductOrderService productOrderService =
                new ProductOrderService(new InformationService(), new OrderingService(), new OrderRepository());

        OrderDto orderResult = productOrderService.process(orderRequestBydgoszczSzczotka);
        System.out.println("order result " + orderResult);

        orderResult = productOrderService.process(orderRequestBydgoszczKapcie);
        orderResult = productOrderService.process(orderRequestWarszawaMiska);

        System.out.println("System total order quantity = " + productOrderService.getTotalOrderQuantity());
        System.out.println("user Bygoszcz orders = " + productOrderService.getUserOrderList(userBydgoszcz));
        System.out.println("user Warszawa orders = " + productOrderService.getUserOrderList(userWarszawa));

    }
}
