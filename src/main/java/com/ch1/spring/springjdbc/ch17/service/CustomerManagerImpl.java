package com.ch1.spring.springjdbc.ch17.service;

import com.ch1.spring.springjdbc.ch17.dao.CustomerDAO;
import com.ch1.spring.springjdbc.ch17.model.Customer;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {
    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        customerDAO.create(customer);
    }
}
