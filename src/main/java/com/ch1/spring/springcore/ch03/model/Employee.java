package com.ch1.spring.springcore.ch03.model;

import com.ch1.spring.springcore.ch03.aspect.Loggable;

public class Employee {
    private String name;

    public String getName() {
        return name;
    }

    @Loggable
    public void setName(String name) {
        this.name = name;
    }

    public void throwException() {
        throw new RuntimeException("Dummy Exception");
    }
}
