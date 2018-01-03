package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepositoryImpl implements OrderRepository {
    private Map<OrderKey, OrderRequest> rentalMap = new HashMap<>();


    @Override
    public void createOrder(OrderRequest orderRequest) {
        rentalMap.put(orderRequest.getOrderKey(), orderRequest);
    }

    @Override
    public OrderRequest getOrderRequest(Integer getOrderId) {
        return rentalMap.get(new OrderKey(getOrderId));
    }

    @Override
    public OrderRequest removeOrderRequest(Integer getOrderId) {
            return rentalMap.remove(new OrderKey(getOrderId));
    }

    @Override
    public List<OrderRequest> getAllExistingOrders() {
        return rentalMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderRequest> getAllUserOrders(User user) {
        return rentalMap.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(rentRequest -> rentRequest.getUser().equals(user))
                .collect(Collectors.toList());
    }
}
