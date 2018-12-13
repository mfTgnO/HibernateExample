package com.ch1.hibernate.ch04.main;

import com.ch1.hibernate.ch03.util.HibernateUtil;
import com.ch1.hibernate.ch04.model.CartMany;
import com.ch1.hibernate.ch04.model.ItemMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class HibernateManyToManyMain {
    //Saving many-to-many where Cart is primary
    public static void main(String[] args) {
        ItemMany iphone = new ItemMany();
        iphone.setPrice(100);
        iphone.setDescription("iPhone");

        ItemMany ipod = new ItemMany();
        ipod.setPrice(50);
        ipod.setDescription("iPod");

        Set<ItemMany> set = new HashSet<>();
        set.add(iphone);
        set.add(ipod);

        CartMany cart = new CartMany();
        cart.setItemManies(set);
        cart.setTotal(150);

        CartMany cart1 = new CartMany();
        Set<ItemMany> itemManies = new HashSet<>();
        itemManies.add(iphone);
        cart1.setItemManies(itemManies);
        cart1.setTotal(100);

        SessionFactory sessionFactory = null;
        try {
            sessionFactory = HibernateUtil.getSeesionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.save(cart);
            session.save(cart1);
            System.out.println("Before committing transaction");
            tx.commit();
            sessionFactory.close();

            System.out.println("Cart ID=" + cart.getId());
            System.out.println("Cart1 ID=" + cart1.getId());
            System.out.println("Item1 ID=" + iphone.getId());
            System.out.println("Item2 ID=" + ipod.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
        }
    }
}
