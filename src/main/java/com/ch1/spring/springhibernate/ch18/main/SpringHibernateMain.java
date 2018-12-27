package com.ch1.spring.springhibernate.ch18.main;

import com.ch1.spring.springhibernate.ch18.dao.PersonDAO;
import com.ch1.spring.springhibernate.ch18.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SpringHibernateMain {
    public static void main(String[] args) throws ParseException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
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

    private static void test3() {
        /*Date date = new Date("2018-12-24 18:53:35");
        System.out.println(date);*/
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
    }

    private static void test4() {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
        System.out.println(date);
    }

    private static void test5() {
        long l = System.currentTimeMillis();
        System.out.println(l);

        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis);
    }

    private static void test6() throws ParseException {
        String str = "2017-10-28 19:27:37";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
        Date parse = sdf.parse(str);

        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        long timeInMillis = instance.getTimeInMillis();
        System.out.println(timeInMillis);
    }

    private static void test7(){
        /*List arrayList = new ArrayList();

        arrayList.add("aaaa");

        arrayList.add(100);


        for(int i = 0; i< arrayList.size();i++){

            String item = (String)arrayList.get(i);

            Log.d("泛型测试","item = " + item);

        }*/
    }

}
