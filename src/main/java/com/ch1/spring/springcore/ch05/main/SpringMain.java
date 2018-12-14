package com.ch1.spring.springcore.ch05.main;

import com.ch1.spring.springcore.ch05.service.EmployeeAutowiredByConstructorService;
import com.ch1.spring.springcore.ch05.service.EmployeeAutowiredByTypeService;
import com.ch1.spring.springcore.ch05.service.EmployeeService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        EmployeeService serviceByName = ctx.getBean("employeeServiceByName", EmployeeService.class);
        System.out.println("Autowiring byName. Employee Name=" + serviceByName.getEmployee().getName());

        EmployeeAutowiredByTypeService serviceByType = ctx.getBean("employeeServiceByType", EmployeeAutowiredByTypeService.class);
        System.out.println("Autowiring byType. Employee Name=" + serviceByType.getEmployee().getName());

        EmployeeAutowiredByConstructorService serviceByConstructor = ctx.getBean("employeeServiceConstructor", EmployeeAutowiredByConstructorService.class);
        System.out.println("Autowiring by Constructor. Employee Name=" + serviceByConstructor.getEmployee().getName());

        //printing hashcode to confirm all the objects are of different type
        /*From the hashcode of all the variables, we have confirmed that all the spring beans are different objects and not referring to the same object.*/
        System.out.println(serviceByName.hashCode() + "::" + serviceByType.hashCode() + "::" + serviceByConstructor.hashCode());

        //Testing @Autowired annotations
        EmployeeAutowiredByTypeService autowiredByTypeService = ctx.getBean("employeeAutowiredByTypeService", EmployeeAutowiredByTypeService.class);
        System.out.println("@Autowired byType. Employee Name=" + autowiredByTypeService.getEmployee().getName());

        EmployeeAutowiredByConstructorService autowiredByConstructorService = ctx.getBean("employeeAutowiredByConstructorService", EmployeeAutowiredByConstructorService.class);
        System.out.println("@Autowired by Constructor. Employee Name=" + autowiredByConstructorService.getEmployee().getName());

        ctx.close();
    }
}
