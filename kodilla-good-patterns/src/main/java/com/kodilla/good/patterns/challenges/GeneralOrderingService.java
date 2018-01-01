package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class GeneralOrderingService {
    private InformationService informationService;
    private OrderingService orderingService;
    private OrderRepository orderRepository;

    public GeneralOrderingService(final InformationService informationService,
                                  final OrderingService orderingService,
                                  final OrderRepository orderRepository) {
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
                .map(OrderRequest::getQuantity)
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
