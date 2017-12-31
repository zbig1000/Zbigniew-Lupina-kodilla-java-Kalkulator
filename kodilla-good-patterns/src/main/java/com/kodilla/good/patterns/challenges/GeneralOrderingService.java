package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class GeneralOrderingService {
    private InformationServiceInterface informationService;
    private OrderingServiceInterface orderingService;
    private OrderRepositoryInterface orderRepository;

    public GeneralOrderingService(final InformationServiceInterface informationService,
                                  final OrderingServiceInterface orderingService,
                                  final OrderRepositoryInterface orderRepository) {
        this.informationService = informationService;
        this.orderingService = orderingService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isSold = orderingService.sale(orderRequest);

        if (isSold) {
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest);
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
    public String getUserOrderList(User user) {
       return orderRepository.getAllUserOrders(user).stream()
                .map(order -> order.getOrderKey().getKey())
                .map(Object::toString)
                .collect(Collectors.joining("'", "<",">"));
    }
    public long getTotalItemOrdered() {
        return orderRepository.getAllExistingOrders().stream()
                .map(order -> order.getQuantity())
                .reduce(0, (total, quantity) -> total += quantity);
    }
    public long getUserOrderQuantity(User user) {
        return orderRepository.getAllUserOrders(user).stream()
                .count();
    }
    public long getTotalOrderQuantity() {
        return orderRepository.getAllExistingOrders().stream()
        .count();
    }
}
