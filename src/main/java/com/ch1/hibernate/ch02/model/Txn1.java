package com.ch1.hibernate.ch02.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transaction")
public class Txn1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "txn_id")
    private long id;

    @Column(name = "txn_date")
    private Date date;

    @Column(name = "txn_total")
    private double total;

    @OneToOne(mappedBy = "txn")
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Customer1 customer1;

    @Override
    public String toString() {
        return "Txn1{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", customer1=" + customer1 +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Customer1 getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer1 customer1) {
        this.customer1 = customer1;
    }
}
