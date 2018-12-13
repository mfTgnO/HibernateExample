package com.ch1.hibernate.ch06.main;

import com.ch1.hibernate.ch02.util.HibernateUtil;
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

        test1(session);
//        test2(session);
        //rolling back to save the test1 data
        tx.rollback();
        //closing hibernate resources
        sessionFactory.close();
    }

    private static void test1(Session session) {
        Query query = session.createQuery("SELECT id,name,salary FROM EmployeeBenefits");
        List<Object[]> rows = query.list();
        for (Object[] row : rows) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }

    private static void test2(Session session) {
        Query query = session.createQuery("SELECT id,name,role,insertTime FROM Employee");
        List<Object[]> rows = query.list();
        for (Object[] row : rows) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
        }
    }
}
