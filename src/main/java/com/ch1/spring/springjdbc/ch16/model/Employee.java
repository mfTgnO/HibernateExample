package com.ch1.spring.springjdbc.ch16.model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 5144092111804428116L;
    private int id;
    private String name;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
