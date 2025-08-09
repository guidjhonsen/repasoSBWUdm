package com.guidjhonsen.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingServiceImpl.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes {} con los argumentos: {}", method, args);
    }

    @After("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingServiceImpl.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues {} con los argumentos: {}", method, args);
    }
}
