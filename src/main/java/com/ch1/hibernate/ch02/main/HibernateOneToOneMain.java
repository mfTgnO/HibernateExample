package com.ch1.hibernate.ch02.main;

import com.ch1.hibernate.ch02.model.Customer;
import com.ch1.hibernate.ch02.model.Txn;
import com.ch1.hibernate.ch02.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class HibernateOneToOneMain {
    public static void main(String[] args) {
        Txn txn = buildDemoTransaction();

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //Get Session
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            //start transaction
            tx = session.beginTransaction();
            //Save the Model object
            session.save(txn);
            //Commit transaction
            tx.commit();
            System.out.println("Transaction ID=" + txn.getId());

            //Get Saved Trasaction Data
            printTransactionData(txn.getId(), sessionFactory);
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (!sessionFactory.isClosed()) {
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }

    private static Txn buildDemoTransaction() {
        Txn txn = new Txn();
        txn.setDate(new Date());
        txn.setTotal(100);

        Customer cust = new Customer();
        cust.setAddress("Bangalore India");
        cust.setEmail("pankaj@gmail.com");
        cust.setName("Pankaj Kumar");

        txn.setCustomer(cust);

        cust.setTxn(txn);
        return txn;
    }

    private static void printTransactionData(long id, SessionFactory sessionFactory) {
        Session session = null;
        Transaction tx = null;
        try {
            //Get Session
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            //start transaction
            tx = session.beginTransaction();
            //Save the Model object
            Txn txn = (Txn) session.get(Txn.class, id);
            //Commit transaction
            System.out.println("Transaction Details=\n" + txn);
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
    }
}
