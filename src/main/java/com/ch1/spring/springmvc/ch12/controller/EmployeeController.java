package com.ch1.spring.springmvc.ch12.controller;

import com.ch1.spring.springmvc.ch12.exception.EmployeeNotFoundException;
import com.ch1.spring.springmvc.ch12.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    /*
    http://localhost:8080/emp/1
    http://localhost:8080/emp/2
    http://localhost:8080/emp/3
    http://localhost:8080/emp/4
    http://localhost:8080/emp/10
*/
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmployee(@PathVariable("id") int id, Model model) throws Exception {
        //deliberately throwing different types of exception
        if (id == 1) {
            throw new EmployeeNotFoundException(id);
        } else if (id == 2) {
            throw new SQLException("SQLException, id=" + id);
        } else if (id == 3) {
            throw new IOException("IOException, id=" + id);
        } else if (id == 10) {
            Employee emp = new Employee();
            emp.setName("Pankaj");
            emp.setId(id);
            model.addAttribute("employee", emp);
            return "home";
        } else {
            throw new Exception("Generic Exception, id=" + id);
        }
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
        logger.error("Requested URL=" + request.getRequestURL());
        logger.error("Exception Raised=" + ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
