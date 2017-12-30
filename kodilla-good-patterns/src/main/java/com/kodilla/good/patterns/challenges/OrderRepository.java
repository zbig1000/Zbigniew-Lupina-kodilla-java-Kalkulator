package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderRepository implements OrderRepositoryInterface {
    private Map<OrderKey, OrderRequest> rentalMap = new HashMap<>();


    @Override
    public void createOrder(OrderRequest orderRequest) {
        rentalMap.put(orderRequest.getOrderKey(), orderRequest);
    }

    @Override
    public OrderRequest getOrderRequest(Integer getOrderId) {
        OrderKey key = new OrderKey(getOrderId);
        return rentalMap.get(key);
    }

    @Override
    public boolean removeOrderRequest(Integer getOrderId) {
        OrderKey key = new OrderKey(getOrderId);
        if (rentalMap.containsKey(key)) {
            rentalMap.remove(key);
            return true;
        } else return false;
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
