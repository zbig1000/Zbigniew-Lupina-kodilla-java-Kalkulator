package com.kodilla.good.patterns.challenges;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class GeneralOrderingServiceImplTestSuite {
    private static int dailyOrderCounter = 0;
    private GeneralOrderingService generalOrderingService;
    private User userBydgoszcz, userWarszawa;
    private OrderRequest orderRequestBydgoszczSzczotka, orderRequestBydgoszczKapcie, orderRequestWarszawaMiska;
    private OrderDto orderResult;

    public static int generateOrderKey() {
        dailyOrderCounter++;
        return LocalDate.now().getDayOfYear() * 1000 + dailyOrderCounter;
    }

    public void prepareTestData() {
        userBydgoszcz = new User("Jan Kowalski", "Bydgoszcz");
        userWarszawa = new User("Antoni Brzechwa", "Warszawa");

        Product szczotka = new Product("szczotka");
        Product kapcie = new Product("kapcie");
        Product miska = new Product("miska");

        orderRequestBydgoszczSzczotka = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(10), szczotka, 2, new OrderKey(generateOrderKey()));
        orderRequestBydgoszczKapcie = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(5), kapcie, 1, new OrderKey(generateOrderKey()));
        orderRequestWarszawaMiska = new OrderRequest(userWarszawa, LocalDate.now(), miska, 1, new OrderKey(generateOrderKey()));

        generalOrderingService =
                new GeneralOrderingService(new InformationServiceImpl(), new OrderingServiceImpl(), new OrderRepositoryImpl());
    }

    @Test
    public void testTotalOrderNumber() {
        // Given
        prepareTestData();

        // When
        orderResult = generalOrderingService.process(orderRequestBydgoszczSzczotka);
        orderResult = generalOrderingService.process(orderRequestBydgoszczKapcie);
        orderResult = generalOrderingService.process(orderRequestWarszawaMiska);

        // Then
        long currentTotalOrderQuantity = generalOrderingService.getTotalOrderQuantity();
        long expectedTotalOrderQuantity = 3;
        assertEquals(expectedTotalOrderQuantity, currentTotalOrderQuantity);
    }

    @Test
    public void testUserOrderNumber() {
        // Given
        prepareTestData();

        // When
        orderResult = generalOrderingService.process(orderRequestBydgoszczSzczotka);
        orderResult = generalOrderingService.process(orderRequestBydgoszczKapcie);
        orderResult = generalOrderingService.process(orderRequestWarszawaMiska);

        // Then
        long expectedTotalOrderQuantity = 2;
        long currentUserOrderQuantity = generalOrderingService.getUserOrderQuantity(userBydgoszcz);
        assertEquals(expectedTotalOrderQuantity, currentUserOrderQuantity);
    }

    @Test
    public void testTotalItemNumber() {
        // Given
        prepareTestData();
        // When
        orderResult = generalOrderingService.process(orderRequestBydgoszczSzczotka);
        orderResult = generalOrderingService.process(orderRequestBydgoszczKapcie);
        orderResult = generalOrderingService.process(orderRequestWarszawaMiska);

        // Then
        long expectedTotalItemQuantity = 4;
        long currentTotalItemQuantity = generalOrderingService.getTotalItemOrdered();
        assertEquals(expectedTotalItemQuantity, currentTotalItemQuantity);
    }
}
