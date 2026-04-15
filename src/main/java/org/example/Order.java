package org.example;

public class Order {
    private long id;
    private String productName;

    public Order(long id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }
}