package com.ch1.spring.springcore.ch05.service;

import com.ch1.spring.springcore.ch05.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeAutowiredByConstructorService {
    private Employee employee;

    @Autowired(required = false)
    public EmployeeAutowiredByConstructorService(@Qualifier("employee") Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}
