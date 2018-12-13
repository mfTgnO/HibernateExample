package com.ch1.hibernate.ch04.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cart_many")
public class CartMany1 {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cart_total")
    private double total;

    @ManyToMany(targetEntity = ItemMany1.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "cart_items",joinColumns = {@JoinColumn(name = "cart_id")},
    inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Set<ItemMany1> itemMany1s;

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

    public Set<ItemMany1> getItemMany1s() {
        return itemMany1s;
    }

    public void setItemMany1s(Set<ItemMany1> itemMany1s) {
        this.itemMany1s = itemMany1s;
    }
}
