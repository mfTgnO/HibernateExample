package com.ch1.spring.springcore.ch06.main;

import com.ch1.spring.springcore.ch06.service.MyAwareService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAwareMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aware.xml");

        ctx.getBean("myAwareService", MyAwareService.class);

        ctx.close();
    }
}
