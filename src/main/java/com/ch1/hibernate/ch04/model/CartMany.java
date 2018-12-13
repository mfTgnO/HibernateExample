package com.ch1.hibernate.ch04.model;

import java.util.Set;

public class CartMany {
    private long id;
    private double total;
    private Set<ItemMany> itemManies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<ItemMany> getItemManies() {
        return itemManies;
    }

    public void setItemManies(Set<ItemMany> itemManies) {
        this.itemManies = itemManies;
    }
}
