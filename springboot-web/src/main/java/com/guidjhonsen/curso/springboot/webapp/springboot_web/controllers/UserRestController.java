package com.guidjhonsen.curso.springboot.webapp.springboot_web.controllers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guidjhonsen.curso.springboot.webapp.springboot_web.models.User;
import com.guidjhonsen.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    
    @GetMapping("/details")
    public UserDto details(){

        User user = new User("Guido", "Paco");
        
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot");
        
        return userDto;
    }
    
    
    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Guido", "Paco");
        User user2 = new User("Pepe", "Mamani");
        User user3 = new User("Ismael", "Janco");

        List<User> users = Arrays.asList(user, user2, user3);
        //List<User> users = new ArrayList<>();

        //users.add(user);
        //users.add(user2);
        //users.add(user3);*/
        return users;
    }

    

    @GetMapping("/details-map")
    public Map<String, Object> details2(){
        User user = new User("Guido", "Paco");

        Map<String, Object> body=new HashMap<>();
        
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

}
