package com.ch1.spring.springhibernate.ch18.main;

import com.ch1.spring.springhibernate.ch18.dao.PersonDAO;
import com.ch1.spring.springhibernate.ch18.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        PersonDAO personDAO = context.getBean(PersonDAO.class);

        Person person = new Person();
        person.setName("Pankaj");
        person.setCountry("India");
        personDAO.save(person);

        System.out.println("Person:" + person);
        List<Person> list = personDAO.list();
        for (Person p : list) {
            System.out.println("Person List:" + p);
        }

        //close resources
        context.close();
    }
}
