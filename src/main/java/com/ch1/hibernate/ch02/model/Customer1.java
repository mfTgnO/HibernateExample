package com.ch1.hibernate.ch02.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer1 {
    @Id
    @Column(name = "txn_id", unique = true, nullable = false)
    @GeneratedValue(generator = "gen")
//    Note that we would need to @GenericGenerator so that id is used from the txn rather than generating it.
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "txn")})
    private long id;

    @Column(name = "cust_name")
    private String name;

    @Column(name = "cust_email")
    private String email;

    @Column(name = "cust_address")
    private String address;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Txn1 txn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Txn1 getTxn() {
        return txn;
    }

    public void setTxn(Txn1 txn) {
        this.txn = txn;
    }
}
