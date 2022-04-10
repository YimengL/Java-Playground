package com.example.sqch8ex4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     * To define a path variable, you assign it a name and put it in the path between curly braces.
     *
     * @param color  You mark the parameter where you want to get the path variable value with the {@code @PathVariable}
     *               annotation. The name of the parameter must be same as the name of the variable in the path.
     * @param page      We also add the Model parameter that we to send data from the controller to the view.
     */
    @RequestMapping("/home/{color}")
    public String home(
            @PathVariable String color,
            Model page) {
        page.addAttribute("username", "Katy");
        page.addAttribute("color", color);
        return "home.html";
    }
}
