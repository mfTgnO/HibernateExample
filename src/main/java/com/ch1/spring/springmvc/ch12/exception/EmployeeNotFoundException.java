package com.ch1.spring.springmvc.ch12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee Not Found")// 404
public class EmployeeNotFoundException extends Exception {

    private static final long serialVersionUID = -5356095293098063048L;

    public EmployeeNotFoundException(int id) {
        super("EmployeeNotFoundException with id=" + id);
    }
}
