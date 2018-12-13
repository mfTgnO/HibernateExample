package com.ch1.hibernate.ch04.main;

import com.ch1.hibernate.ch03.util.HibernateAnnotationUtil;
import com.ch1.hibernate.ch04.model.CartMany1;
import com.ch1.hibernate.ch04.model.ItemMany1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class HibernateManyToManyAnnotationMain {
    public static void main(String[] args) {
        ItemMany1 item1 = new ItemMany1();
        item1.setDescription("samsung");
        item1.setPrice(300);

        ItemMany1 item2 = new ItemMany1();
        item2.setDescription("nokia");
        item2.setPrice(200);


        Set<ItemMany1> items = new HashSet<>();
        items.add(item1);
        items.add(item2);

        CartMany1 cart = new CartMany1();
        cart.setTotal(500);
        cart.setItemMany1s(items);

        SessionFactory sessionFactory = null;
        try {
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(cart);
            System.out.println("Before committing transaction");
            tx.commit();
            sessionFactory.close();

            System.out.println("Cart ID="+cart.getId());
            System.out.println("Item1 ID="+item1.getId());
            System.out.println("Item2 ID="+item2.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
        }

    }
}
