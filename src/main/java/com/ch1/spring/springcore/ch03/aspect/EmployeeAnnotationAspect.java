package com.ch1.spring.springcore.ch03.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class EmployeeAnnotationAspect {
    @Before("@annotation(com.ch1.spring.springcore.ch03.aspect.Loggable)")
    public void myAdvice() {
        System.out.println("Executing myAdvice!!");
    }
}
