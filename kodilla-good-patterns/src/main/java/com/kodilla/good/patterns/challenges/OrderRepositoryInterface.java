package com.kodilla.good.patterns.challenges;

import java.util.List;

public interface OrderRepositoryInterface {
    void createOrder(OrderRequest orderRequest);

    OrderRequest getOrderRequest(Integer getOrderId);
    boolean removeOrderRequest(Integer getOrderId);

    List<OrderRequest> getAllExistingOrders();
    List<OrderRequest> getAllUserOrders(User user);
}

