package com.guidjhonsen.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) // Define the order of execution for this aspect
@Component
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingService.foo(..))")
    private void greetingFooLoggerPintCut() {
        // This method is used to define the pointcut for the GreetingService methods
    }
    @Before("greetingFooLoggerPintCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes FOO {} invocado con los parametros: {}", method, args);
    }
}
