package com.ch1.spring.springcore.ch03.service;

import com.ch1.spring.springcore.ch03.model.Employee;

public class EmployeeService {
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
