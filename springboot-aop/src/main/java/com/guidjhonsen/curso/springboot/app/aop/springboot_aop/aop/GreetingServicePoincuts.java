package com.guidjhonsen.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePoincuts {
    @Pointcut("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingService.foo(..))")
    public void greetingFooLoggerPintCut() {
        // This method is used to define the pointcut for the GreetingService methods
    }

    @Pointcut("execution(* com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPintCut() {
    }

}
