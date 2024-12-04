package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Novo controller para mostrar o formulário html

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // Novo controller para processar o formulário html

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // metódo Controller para ler os dados do formulário e adicionar dados ao formulário
    @PostMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

       // ler o request do formulário HTML
        String theName = request.getParameter("studentName");

        //Converter os dados para maiúsculas
        theName = theName.toUpperCase();

        //criar a mensagem
        String result = "Yo! " + theName;

        //adicionar mensagem para o model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

        //Converter os dados para maiúsculas
        theName = theName.toUpperCase();

        //criar a mensagem
        String result = "Hey My Friend from v3! " + theName;

        //adicionar mensagem para o model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
