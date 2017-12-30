package com.kodilla.good.patterns.challenges;

import org.junit.Test;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class OrdernigServiceTestSuite {
    private static int dailyOrderCounter = 0;
    ProductOrderService productOrderService;
    User userBydgoszcz, userWarszawa;

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

        OrderRequest orderRequestBydgoszczSzczotka = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(10), szczotka, 2, new OrderKey(generateOrderKey()));
        OrderRequest orderRequestBydgoszczKapcie = new OrderRequest(userBydgoszcz, LocalDate.now().minusWeeks(5), kapcie, 1, new OrderKey(generateOrderKey()));
        OrderRequest orderRequestWarszawaMiska = new OrderRequest(userWarszawa, LocalDate.now(), miska, 1, new OrderKey(generateOrderKey()));

        productOrderService =
                new ProductOrderService(new InformationServicePerformer(), new OrderingServicePerformer(), new OrderRepositoryVendor());

        OrderDto orderResult = productOrderService.process(orderRequestBydgoszczSzczotka);
        orderResult = productOrderService.process(orderRequestBydgoszczKapcie);
        orderResult = productOrderService.process(orderRequestWarszawaMiska);
    }

    @Test
    public void testTotalOrderNumber() {
        // Given
        prepareTestData();
        // When
        long currentTotalOrderQuantity = productOrderService.getTotalOrderQuantity();

        // Then
        long expectedTotalOrderQuantity = 3;
        assertEquals(expectedTotalOrderQuantity, currentTotalOrderQuantity);
    }

    @Test
    public void testUserOrderNumber() {
        // Given
        prepareTestData();
        // When
        long currentUserOrderQuantity = productOrderService.getUserOrderQuantity(userBydgoszcz);

        // Then
        long expectedTotalOrderQuantity = 2;
        assertEquals(expectedTotalOrderQuantity, currentUserOrderQuantity);
    }
    @Test
    public void testTotalItemNumber() {
        // Given
        prepareTestData();
        // When
        long currentTotalItemQuantity = productOrderService.getTotalItemOrdered();

        // Then
        long expectedTotalItemQuantity = 4;
        assertEquals(expectedTotalItemQuantity, currentTotalItemQuantity);
    }
}
