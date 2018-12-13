package com.ch1.spring.springcore.ch03.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointcut {
    @Before("getNamePointCut()")
    public void loggingAdvice() {
        System.out.println("Executing loggingAdvice on getName()");
    }

    @Before("getNamePointCut()")
    public void secondAdvice() {
        System.out.println("Executing secondAdvice on getName()");
    }

    @Pointcut("execution(public String getName())")
    public void getNamePointCut() {

    }

    @Before("allMethodsPointCut()")
    public void allServiceMethodAdvice() {
        System.out.println("Before executing service method");
    }

    //Pointcut to execute on all the methods of classes in a package
    @Pointcut("within(com.ch1.spring.springcore.ch03.service.*)")
    public void allMethodsPointCut() {
    }
}
