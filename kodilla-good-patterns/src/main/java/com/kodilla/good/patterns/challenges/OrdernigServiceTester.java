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

        GeneralOrderingService generalOrderingService =
                new GeneralOrderingService(new InformationServiceImpl(), new OrderingServiceImpl(), new OrderRepositoryImpl());

        OrderDto orderResult = generalOrderingService.process(orderRequestBydgoszczSzczotka);
        System.out.println("order result " + orderResult);

        orderResult = generalOrderingService.process(orderRequestBydgoszczKapcie);
        orderResult = generalOrderingService.process(orderRequestWarszawaMiska);

        System.out.println("System total order quantity = " + generalOrderingService.getTotalOrderQuantity());
        System.out.println("user Bygoszcz orders = " + generalOrderingService.getUserOrderList(userBydgoszcz));
        System.out.println("user Warszawa orders = " + generalOrderingService.getUserOrderList(userWarszawa));

    }
}
