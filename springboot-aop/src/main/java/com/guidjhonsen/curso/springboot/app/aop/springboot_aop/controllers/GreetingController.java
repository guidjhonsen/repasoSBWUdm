package com.guidjhonsen.curso.springboot.app.aop.springboot_aop.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.guidjhonsen.curso.springboot.app.aop.springboot_aop.services.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;
    @GetMapping("/greeting")
    public ResponseEntity <?> greeting() {
        return ResponseEntity.ok(Collections.singletonMap("greeting", greetingService.sayHello("World", "Welcome to Spring Boot AOP!")));
    }
    
}
