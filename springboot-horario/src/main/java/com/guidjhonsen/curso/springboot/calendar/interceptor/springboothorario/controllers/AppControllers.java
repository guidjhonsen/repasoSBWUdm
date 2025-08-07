package com.guidjhonsen.curso.springboot.calendar.interceptor.springboothorario.controllers;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppControllers {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request) {
        
        Map<String, Object> data = new HashMap<>();

        data.put("title", "Hello, World!");
        data.put("time", new Date());
        data.put("message", request.getAttribute("message"));
        return ResponseEntity.ok(data);
    }
}
