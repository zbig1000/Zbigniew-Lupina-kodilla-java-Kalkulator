package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User user;
    private boolean orderStatus;

    public OrderDto(User user, boolean orderStatus) {
        this.user = user;
        this.orderStatus = orderStatus;
    }

    public User getUser() {
        return user;
    }

    public boolean orderStatus() {
        return orderStatus;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "user=" + user +
                ", orderStatus=" + orderStatus +
                '}';
    }
}

