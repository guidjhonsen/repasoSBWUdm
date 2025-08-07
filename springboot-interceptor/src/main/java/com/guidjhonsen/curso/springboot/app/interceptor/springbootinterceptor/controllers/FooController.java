package com.guidjhonsen.curso.springboot.app.interceptor.springbootinterceptor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/foo")
    public Map<String, String> foo() {
        
        
        return Collections.singletonMap("foo", "handlres foo del controlador");
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {
        
        
        return Collections.singletonMap("foo", "handler bar delcontrolador");
    }

    
    @GetMapping("/baz")
    public Map<String, String> baz() {
              
        return Collections.singletonMap("foo", "handlres foo delcontrolador");
    }

}
