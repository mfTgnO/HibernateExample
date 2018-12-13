package com.ch1.hibernate.ch04.model;

import java.util.Set;

public class ItemMany {
    private long id;
    private double price;
    private String description;
    private Set<CartMany> cartManies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<CartMany> getCartManies() {
        return cartManies;
    }

    public void setCartManies(Set<CartMany> cartManies) {
        this.cartManies = cartManies;
    }
}
