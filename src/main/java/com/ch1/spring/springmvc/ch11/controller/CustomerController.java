package com.ch1.spring.springmvc.ch11.controller;

import com.ch1.spring.springmvc.ch11.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private Map<String, Customer> customers = null;

    public CustomerController() {
        this.customers = new HashMap<>();
    }

    @RequestMapping(value = "/cust/save", method = RequestMethod.GET)
    public String saveCustomerPage(Model model) {
        logger.info("Returning custSave.jsp page");
        model.addAttribute("customer", new Customer());
        return "custSave";
    }

    @RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
    public String saveCustomerAction(@Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            logger.info("Returning custSave.jsp page");
            return "custSave";
        }
        logger.info("Returning custSaveSuccess.jsp page");
        model.addAttribute("customer", customer);
        customers.put(customer.getEmail(), customer);
        return "custSaveSuccess";
    }
}
