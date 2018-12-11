package com.ch1.hibernate.main;

import com.ch1.hibernate.model.Employee;
import com.ch1.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class HibernateMain {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("David");
        emp.setRole("Developer");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
