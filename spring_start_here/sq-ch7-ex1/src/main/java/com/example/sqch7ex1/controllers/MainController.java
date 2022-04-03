package com.example.sqch7ex1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// We annotate the class with the @Controller stereotype annotation
@Controller
public class MainController {

    @RequestMapping("/home")
    /**
     * We use the {@link @RequestMapping} annotation to associate the action with an HTTP request path
     */
    public String home() {
        return "home.html";
    }
}
