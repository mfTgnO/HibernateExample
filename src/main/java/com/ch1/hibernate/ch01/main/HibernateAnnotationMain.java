package com.ch1.hibernate.ch01.main;

import com.ch1.hibernate.ch01.model.Employee1;
import com.ch1.hibernate.ch01.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class HibernateAnnotationMain {
    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.setName("David");
        emp.setRole("Developer");
        emp.setInsertTime(new Date());

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}