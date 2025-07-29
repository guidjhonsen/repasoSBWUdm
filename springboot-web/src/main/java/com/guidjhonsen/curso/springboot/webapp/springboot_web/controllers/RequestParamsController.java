package com.guidjhonsen.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guidjhonsen.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import com.guidjhonsen.curso.springboot.webapp.springboot_web.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false) String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message!=null?message:"Hola");
        return param;
    }
    
    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamDto params=new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    @GetMapping("/request")
    public ParamMixDto getMethodName(HttpServletRequest request) {
        Integer code=0;
        try{
            code=Integer.parseInt(request.getParameter("code"));
        }catch(NumberFormatException e){
        }
        ParamMixDto params=new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        
        return params;
    }
    

}
