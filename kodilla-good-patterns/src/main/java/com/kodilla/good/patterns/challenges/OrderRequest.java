package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;
import java.util.Objects;

public class OrderRequest {
    private User user;
    private LocalDate fromDate;
    private Product product;
    private int quantity;
    private OrderKey orderKey;
    private String status;

    public OrderRequest(User user, LocalDate fromDate, Product product, int quantity, OrderKey orderKey) {
        this.user = user;
        this.fromDate = fromDate;
        this.product = product;
        this.quantity = quantity;
        this.orderKey = orderKey;
        this.status = "new";
    }

    public User getUser() {
        return user;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderKey getOrderKey() {
        return orderKey;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRequest that = (OrderRequest) o;
        return Objects.equals(user, that.user) &&
                Objects.equals(orderKey, that.orderKey);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "user=" + user +
                ", fromDate=" + fromDate +
                ", product=" + product +
                ", quantity=" + quantity +
                ", orderKey=" + orderKey +
                ", status='" + status + '\'' +
                '}';
    }
}
