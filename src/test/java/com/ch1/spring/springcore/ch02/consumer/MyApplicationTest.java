package com.ch1.spring.springcore.ch02.consumer;

import com.ch1.spring.springcore.ch02.services.MessageService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.ch1.spring.springcore.ch02.consumer")
public class MyApplicationTest {
    private AnnotationConfigApplicationContext context = null;

    @Bean
    public MessageService getMessageService() {
        return new MessageService() {
            @Override
            public boolean sendMessage(String msg, String rec) {
                System.out.println("Mock Service");
                return true;
            }
        };
    }

    @Before
    public void setUp() {
//        context = new AnnotationConfigApplicationContext(MyApplication.class);
        context = new AnnotationConfigApplicationContext(MyApplicationTest.class);
    }

    @After
    public void tearDown() {
        context.close();
    }

    @Test
    public void test() {
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hi Pankaj", "pankaj@abc.com"));
    }
}