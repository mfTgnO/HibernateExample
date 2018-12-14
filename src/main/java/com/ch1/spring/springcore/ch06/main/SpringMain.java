package com.ch1.spring.springcore.ch06.main;

import com.ch1.spring.springcore.ch06.service.EmployeeService;
import com.ch1.spring.springcore.ch06.service.MyEmployeeService;
import com.ch1.spring.springcore.ch06.service.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    From the console output it’s clear that Spring Context is first using no-args constructor to initialize the bean object and then calling the post-init method.
    The order of bean initialization is same as it’s defined in the spring bean configuration file.
    The context is returned only when all the spring beans are initialized properly with post-init method executions.
    Employee name is printed as “Pankaj” because it was initialized in the post-init method.
    When context is getting closed, beans are destroyed in the reverse order in which they were initialized i.e in LIFO (Last-In-First-Out) order.
*/
public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("Spring Context initialized");

        //MyEmployeeService service = ctx.getBean("myEmployeeService", MyEmployeeService.class);
        EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);
        MyEmployeeService myEmployeeService = ctx.getBean("myEmployeeService", MyEmployeeService.class);
        MyService myService = ctx.getBean("myService", MyService.class);

        System.out.println("Bean retrieved from Spring Context");

        System.out.println("-------------------------------------------");
        System.out.println("Employee Name=" + service.getEmployee().getName());
        System.out.println("MyEmployeeService Name=" + myEmployeeService.getEmployee().getName());
        System.out.println("------------------------------------------- ");

        ctx.close();
        System.out.println("Spring Context Closed");
    }
}
