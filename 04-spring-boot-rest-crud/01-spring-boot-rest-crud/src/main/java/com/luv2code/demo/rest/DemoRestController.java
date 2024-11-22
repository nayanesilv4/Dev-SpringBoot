package com.luv2code.demo.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    //Código para o endpoint "/hello"

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World!";
    }
}
