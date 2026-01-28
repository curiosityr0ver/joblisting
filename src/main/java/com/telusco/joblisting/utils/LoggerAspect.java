package com.telusco.joblisting.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LoggerAspect.class);

    @Before("execution(public * com.telusco.joblisting.controller.PostController.getAllPosts())")
    public void logBefore() {
        LOG.warn("Logger has been triggered before getAllPosts() could be called");
    }

    @After("execution(public * com.telusco.joblisting.controller.PostController.getAllPosts())")
    public void logAfter() {
        LOG.warn("Logger has been triggered after getAllPosts() was called");
    }


}
