package com.guidjhonsen.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.guidjhonsen.curso.springboot.webapp.springboot_web.models.User;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    
    @GetMapping("/details")
    public Map<String, Object> details(){

        User user = new User("Guido", "Paco");
        user.setEmail("guidjhonsen.tu.rey@gmail.com");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        //List<User> users=new ArrayList<>();
        //List<User> users=Arrays.asList(new User("Pepa", "Gonzales"),
        //                            new User("Ramiro", "Morón", "ramiro@gmail.com"),
        //                            new User("Marco", "Patty", "patty17@gmail.com"),
        //                            new User("Diego", "Quispe"));
        //model.addAttribute("users", users);
        model.addAttribute("title", "Listado de Usuarios");
        return "list";
    }
    
    @ModelAttribute("users")
    public List<User> usersModel(){
        List<User> users=Arrays.asList(new User("Pepa", "Gonzales"),
                                    new User("Ramiro", "Morón", "ramiro@gmail.com"),
                                    new User("Marco", "Patty", "patty17@gmail.com"),
                                    new User("Diego", "Quispe"));
        return users;
    }

}
