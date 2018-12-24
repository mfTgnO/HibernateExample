package com.ch1.spring.springhibernate.ch18.main;

import com.ch1.spring.springhibernate.ch18.dao.PersonDAO;
import com.ch1.spring.springhibernate.ch18.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
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

    private static void test2() {
        String str = "有志者，事竟成，破釜沉舟，百二秦关终属楚；苦心人，天不负，卧薪尝胆，三千越甲可吞吴。——蒲松龄";
        System.out.println(str);

        String result = str.substring(0, 10);
        System.out.println(result);

    }
}
