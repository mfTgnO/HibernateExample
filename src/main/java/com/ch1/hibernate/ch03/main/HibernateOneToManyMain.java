package com.ch1.hibernate.ch03.main;

import com.ch1.hibernate.ch03.model.Cart;
import com.ch1.hibernate.ch03.model.Items;
import com.ch1.hibernate.ch03.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class HibernateOneToManyMain {
    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.setName("MyCart");

        Items items1 = new Items("I1", 10, 1, cart);
        Items items2 = new Items("I2", 20, 2, cart);

        Set<Items> items = new HashSet<>();
        items.add(items1);
        items.add(items2);

        cart.setItems(items);
        cart.setTotal(10 * 1 + 20 * 2);

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        try {
            //Get Session
            sessionFactory = HibernateUtil.getSeesionFactory();
            session = sessionFactory.getCurrentSession();
            System.out.println("Session created");
            //start transaction
            tx = session.beginTransaction();

            //Save the Model objects
            session.save(cart);
            session.save(items1);
            session.save(items2);

            //Commit transaction
            tx.commit();
            System.out.println("Cart ID=" + cart.getId());
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
}
