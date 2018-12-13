package com.ch1.spring.springcore.ch02.services;

public class TwitterService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.out.println("Twitter message Sent to " + rec + " with Message=" + msg);
        return true;
    }
}
