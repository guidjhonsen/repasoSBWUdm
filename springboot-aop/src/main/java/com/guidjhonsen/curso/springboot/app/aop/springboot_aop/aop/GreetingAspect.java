package com.guidjhonsen.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2) // Define the order of execution for this aspect
@Aspect
@Component
public class GreetingAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void greetingLoggerPintCut() {
    }

    @Before("greetingLoggerPintCut()")
    public void loggerBefore(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes {} con los argumentos: {}", method, args);
    }

    @After("greetingLoggerPintCut()")
    public void loggerAfter(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues {} con los argumentos: {}", method, args);
    }

    @AfterReturning("greetingLoggerPintCut()")
    public void loggerAfterReturning(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de retornar {} con los argumentos: {}", method, args);
    }

    @AfterThrowing("greetingLoggerPintCut()")
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Despues de lanzar la excepcion {} con los argumentos: {}", method, args);
    }
    @Around("greetingLoggerPintCut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            logger.info("Antes de ejecutar el método: {} con los argumentos: {}", method, args);
            result = joinPoint.proceed();
            logger.info("Después de ejecutar el método: {} con el resultado: {}", method, result);
            return result; // Implementar si se desea un comportamiento alrededor del método
        } catch (Throwable e) {
            logger.error("Error al registrar antes de ejecutar el método: {}", e.getMessage());
            throw e;
        }
    }

}
