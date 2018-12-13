package com.ch1.spring.springcore.ch02.consumer;

import com.ch1.spring.springcore.ch02.services.MessageService;

public class MyXMLApplication {
    private MessageService service;

    /*public MyXMLApplication(TwitterService twitterService) {

    }*/

    public void setService(MessageService service) {
        this.service = service;
    }

    public boolean processMessage(String msg, String rec) {
        // some magic like validation, logging etc
        return this.service.sendMessage(msg, rec);
    }
}
