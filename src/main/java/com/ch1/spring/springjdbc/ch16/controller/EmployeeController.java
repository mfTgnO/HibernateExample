package com.ch1.spring.springjdbc.ch16.controller;

import com.ch1.spring.springjdbc.ch16.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Handles requests for the Employee JDBC Service.
 */
@Controller
public class EmployeeController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    @Qualifier("dbDataSource")
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
    public List<Employee> getAllEmployee() {
        logger.info("Start getAllEmployees.");
        List<Employee> empList = new ArrayList<>();
        //JDBC Code - Start
        String query = "select id, name, role from Employee";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Map<String, Object>> empRows = jdbcTemplate.queryForList(query);
        for (Map<String, Object> empRow : empRows) {
            Employee emp = new Employee();
            emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
            emp.setName(String.valueOf(empRow.get("name")));
            emp.setRole(String.valueOf(empRow.get("role")));
            empList.add(emp);
        }
        return empList;
    }
}
