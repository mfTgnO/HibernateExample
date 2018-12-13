package com.ch1.spring.springcore.ch02.test;

import com.ch1.spring.springcore.ch02.consumer.MyXMLApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClientXMLApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyXMLApplication app = context.getBean(MyXMLApplication.class);

        app.processMessage("Hi Pankaj", "pankaj@abc.com");

        // close the context
        context.close();
    }
}
