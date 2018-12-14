package com.ch1.spring.springcore.ch05.service;

import com.ch1.spring.springcore.ch05.model.Employee;

/*We will use the same service class for perform spring autowiring byName, byType and by constructor. The setter method will be used for spring autowiring byName and byType whereas constructor based injection will be used by constructor autowire attribute.

When we use spring autowire byName or byType, default constructor is used. That’s why we have explicitly defined the default constructor for the EmployeeService bean.*/
public class EmployeeService {
    private Employee employee;

    // constructor is used for autowire by constructor
    public EmployeeService(Employee employee) {
        this.employee = employee;
    }

    // default constructor to avoid BeanInstantiationException for autowire
    // byName or byType
    public EmployeeService() {
        System.out.println("Default Constructor used");
    }

    // used for autowire byName and byType
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
