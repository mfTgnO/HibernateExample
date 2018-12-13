package com.ch1.spring.springcore.ch02.consumer;

import com.ch1.spring.springcore.ch02.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApplication {
    private MessageService service;

    @Autowired
    public void setService(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String rec) {
        //some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
