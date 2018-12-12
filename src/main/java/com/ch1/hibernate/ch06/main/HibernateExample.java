package com.ch1.hibernate.ch06.main;

import com.ch1.hibernate.ch02.util.HibernateUtil;
import com.ch1.hibernate.ch05.model.EmployeeBenefits;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateExample {
    public static void main(String[] args) {
        //Prep work
//        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        test(session);
        //rolling back to save the test data
        tx.rollback();
        //closing hibernate resources
        sessionFactory.close();
    }

    private static void test(Session session) {
        Query query = session.createQuery("select id, name, salary from EmployeeBenefits");
//        Query query = session.createQuery("select id, name, role, insert_time from Employee");
//        Query query = session.createQuery("select id,name,role,insertTime from Employee");
        List<Object[]> rows = query.list();
        for (Object[] row : rows) {
            EmployeeBenefits emp = new EmployeeBenefits();
            emp.setId(Long.parseLong(row[0].toString()));
            emp.setName(row[1].toString());
            emp.setSalary(Double.parseDouble(row[2].toString()));

            System.out.println(emp);
//            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
        }
    }
}
