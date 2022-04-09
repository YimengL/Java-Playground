package com.example.sqch8ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    /**
     * @param name   Gets the new request parameter "name"
     * @param color  We define a new parameter for the controller's action method and annotate it with
     * {@code @RequestParam}
     * @param page  We also add the Model parameter that we to send data from the controller to the view.
     */
    @RequestMapping("/home")
    public String home(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            Model page) {
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";
    }
}
