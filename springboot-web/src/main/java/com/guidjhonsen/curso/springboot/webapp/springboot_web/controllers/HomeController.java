package com.guidjhonsen.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public String home() {

        //redirect cambia la ruta
        //return "redirect:/list";
        //no cambia la ruta
        return "forward:/list";
    }
    
}
