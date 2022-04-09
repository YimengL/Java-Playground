package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    /**
     *
     * @param color  We define a new parameter for the controller's action method and annotate it with
     * {@code @RequestParam}
     * @param page  We also add the Model parameter that we to send data from the controller to the view.
     */
    @RequestMapping("/home")
    public String home(@RequestParam String color, Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", color);
        return "home.html";
    }
}
