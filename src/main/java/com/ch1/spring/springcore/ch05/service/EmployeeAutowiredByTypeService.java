package com.ch1.spring.springcore.ch05.service;

import com.ch1.spring.springcore.ch05.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeAutowiredByTypeService {
    //Autowired annotation on variable/setters is equivalent to autowire="byType"
    @Autowired
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    @Autowired
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
