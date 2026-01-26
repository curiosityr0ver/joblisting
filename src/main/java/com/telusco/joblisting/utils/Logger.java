package com.telusco.joblisting.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

    @Before("execution(public * com.telusco.joblisting.controller.PostController.getAllPosts())")
    public void log() {
        System.out.println("Logger has been triggered");
    }
}
