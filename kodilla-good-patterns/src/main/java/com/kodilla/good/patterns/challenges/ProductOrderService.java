package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class ProductOrderService {
    private InformationServiceInterface informationServiceInterface;
    private OrderingServiceInterface orderingServiceInterface;
    private OrderRepositoryInterface orderRepositoryInterface;

    public ProductOrderService(final InformationServiceInterface informationServiceInterface,
                           final OrderingServiceInterface orderingServiceInterface,
                           final OrderRepositoryInterface orderRepositoryInterface) {
        this.informationServiceInterface = informationServiceInterface;
        this.orderingServiceInterface = orderingServiceInterface;
        this.orderRepositoryInterface = orderRepositoryInterface;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isSold = orderingServiceInterface.sale(orderRequest);

        if (isSold) {
            informationServiceInterface.inform(orderRequest.getUser());
            orderRepositoryInterface.createOrder(orderRequest);
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
    public String getUserOrderList(User user) {
       return orderRepositoryInterface.getAllUserOrders(user).stream()
                .map(order -> order.getOrderKey().getKey())
                .map(Object::toString)
                .collect(Collectors.joining("'", "<",">"));
    }
    public long getTotalItemOrdered() {
        return orderRepositoryInterface.getAllExistingOrders().stream()
                .map(order -> order.getQuantity())
                .reduce(0, (total, quantity) -> total = total + quantity);
    }
    public long getUserOrderQuantity(User user) {
        return orderRepositoryInterface.getAllUserOrders(user).stream()
                .count();
    }
    public long getTotalOrderQuantity() {
        return orderRepositoryInterface.getAllExistingOrders().stream()
        .count();
    }
}
