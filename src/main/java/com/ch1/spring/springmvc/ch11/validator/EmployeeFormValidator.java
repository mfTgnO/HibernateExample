package com.ch1.spring.springmvc.ch11.validator;


import com.ch1.spring.springmvc.ch11.model.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmployeeFormValidator implements Validator {
    //which objects can be validated by this validator
    @Override
    public boolean supports(Class<?> clazz) {
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");

        Employee emp = (Employee) obj;
        if(emp.getId()<=0){
            errors.rejectValue("id", "negativeValue", new Object[]{"'id'"},"id can't be negative");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
    }
}
