package com.ch1.spring.springmvc.ch08.controller;

import com.ch1.spring.springmvc.ch08.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Handles requests for the Employee service.
 */
@Controller
//@RestController
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    //Map to store employees, ideally we should use database
    Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

    //    http://localhost:8080//rest/emp/dummy
    @RequestMapping(value = EmpRestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
    public @ResponseBody
    Employee getDummyEmployee() {
        logger.info("Start getDummyEmployee");
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreateDate(new Date());
        empData.put(9999, emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.GET_EMP, method = RequestMethod.GET)
    public @ResponseBody
    Employee getEmployee(@PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID=" + empId);

        return empData.get(empId);
    }

    @RequestMapping(value = EmpRestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public @ResponseBody
    List<Employee> getAllEmployee() {
        logger.info("Start getAllEmployees.");
        List<Employee> emps = new ArrayList<>();
        Set<Integer> empIdKeys = empData.keySet();
        for (Integer i : empIdKeys) {
            emps.add(empData.get(i));
        }
        return emps;
    }

    /*
        {
            "id":"1",
            "nameadsf":"tomasdfa",
            "createDate":"2018-12-15"
        }
    */
    @RequestMapping(value = EmpRestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        emp.setCreateDate(new Date());
        empData.put(emp.getId(), emp);
        return emp;
    }

    @RequestMapping(value = EmpRestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
    public @ResponseBody
    Employee deleteEmployee(@PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }
}
