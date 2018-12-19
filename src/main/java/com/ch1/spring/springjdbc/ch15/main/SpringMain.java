package com.ch1.spring.springjdbc.ch15.main;

import com.ch1.spring.springjdbc.ch15.dao.EmployeeDao;
import com.ch1.spring.springjdbc.ch15.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        //Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        //Get the EmployeeDAO Bean
//        EmployeeDao employeeDAO = ctx.getBean("employeeDAO", EmployeeDao.class);
        EmployeeDao employeeDAO = ctx.getBean("employeeDAOJDBCTemplate", EmployeeDao.class);

        //Run some tests for JDBC CRUD operations
        Employee emp = new Employee();
//        int rand = new Random().nextInt(1000);
        emp.setName("Pankaj");
        emp.setRole("Java Developer");
        emp.setInsert_time(new Date());

        //Create
        employeeDAO.save(emp);

        //Read
        Employee emp1 = employeeDAO.getById(2);
        System.out.println("Employee Retrieved::" + emp1);

        //Update
        emp.setRole("CEO");
        employeeDAO.update(emp);

        //Get All
        List<Employee> empList = employeeDAO.getAll();
        System.out.println(empList);

        //Delete
        employeeDAO.deleteById(3);

        //Close Spring Context
        ctx.close();

        System.out.println("DONE");
    }
}
