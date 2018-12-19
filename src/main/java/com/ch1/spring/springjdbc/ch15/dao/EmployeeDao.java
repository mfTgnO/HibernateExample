package com.ch1.spring.springjdbc.ch15.dao;

import com.ch1.spring.springjdbc.ch15.model.Employee;

import java.util.List;

//CRUD operations
public interface EmployeeDao {
    //Create
    void save(Employee employee);

    //Read
    Employee getById(int id);

    //Update
    void update(Employee employee);

    //Delete
    void deleteById(int id);

    //Get All
    List<Employee> getAll();
}
