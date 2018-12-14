package com.ch1.spring.springcore.ch04.main;

import java.util.Date;

public class MyService {
    public void log(String msg) {
        System.out.println(new Date() + "::" + msg);
    }
}
