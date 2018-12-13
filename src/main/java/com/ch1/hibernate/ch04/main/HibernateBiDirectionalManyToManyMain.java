package com.ch1.hibernate.ch04.main;

import com.ch1.hibernate.ch02.util.HibernateUtil;
import com.ch1.hibernate.ch04.model.CartMany;
import com.ch1.hibernate.ch04.model.ItemMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class HibernateBiDirectionalManyToManyMain {
    //Saving many-to-many where Item is primary
    public static void main(String[] args) {

        ItemMany iphone = new ItemMany();
        iphone.setPrice(100); iphone.setDescription("iPhone");

        ItemMany ipod = new ItemMany();
        ipod.setPrice(50); ipod.setDescription("iPod");

        CartMany cart = new CartMany();
        cart.setTotal(150);

        CartMany cart1 = new CartMany();
        cart1.setTotal(100);

        Set<CartMany> cartSet = new HashSet<CartMany>();
        cartSet.add(cart);cartSet.add(cart1);

        Set<CartMany> cartSet1 = new HashSet<CartMany>();
        cartSet1.add(cart);

        iphone.setCartManies(cartSet1);
        ipod.setCartManies(cartSet);

        SessionFactory sessionFactory = null;
        try{
            sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(iphone);
            session.save(ipod);
            tx.commit();
            sessionFactory.close();

            System.out.println("Cart ID="+cart.getId());
            System.out.println("Cart1 ID="+cart1.getId());
            System.out.println("Item1 ID="+iphone.getId());
            System.out.println("Item2 ID="+ipod.getId());

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
        }

    }
}
