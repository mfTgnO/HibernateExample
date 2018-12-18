package com.ch1.spring.springmvc.ch12.resolver;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;

public class MySimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    @Override
    protected String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}
