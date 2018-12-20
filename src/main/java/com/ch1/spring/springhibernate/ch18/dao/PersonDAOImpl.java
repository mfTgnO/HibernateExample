package com.ch1.spring.springhibernate.ch18.dao;

import com.ch1.spring.springhibernate.ch18.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Person p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }
}
