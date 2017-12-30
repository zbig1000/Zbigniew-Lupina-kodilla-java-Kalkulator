package com.kodilla.good.patterns.challenges;

public class OrderKey {
    private int key;

    public OrderKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey that = (OrderKey) o;
        return key == that.key;
    }

    @Override
    public int hashCode() {
        return key/1000 ;
    }

    @Override
    public String toString() {
        return "OrderKey{" +
                "key=" + key +
                '}';
    }
}
