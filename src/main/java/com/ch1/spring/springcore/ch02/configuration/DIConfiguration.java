package com.ch1.spring.springcore.ch02.configuration;

import com.ch1.spring.springcore.ch02.services.EmailService;
import com.ch1.spring.springcore.ch02.services.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.ch1.spring.springcore.ch02.consumer")
public class DIConfiguration {
    @Bean
    public MessageService getMessageService() {
        return new EmailService();
    }
}
