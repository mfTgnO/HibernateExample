package com.ch1.spring.springcore.ch04.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.ch1.spring.springcore.ch04.main")
public class MyConfiguration {
    @Bean
    public MyService getMyService() {
        return new MyService();
    }
}
