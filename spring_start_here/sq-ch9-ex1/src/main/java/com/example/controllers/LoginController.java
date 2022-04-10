package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * We use the {@code @Controller} stereotype annotation to define the class as a Spring MVC controller
 */
@Controller
public class LoginController {

    /**
     * We map the controller's action to the root("/") path of the application.
     * @return  We return the view name we want to be rendered by the app.
     */
    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }


    /**
     * We are mapping the controller's action to the HTTP POST request of the login page.
     *
     * @param model     We declare a {@code Model} parameter to send the message value to the view.
     * @return  We return the view name, which is still login.html, so we remain on the same page.
     */
    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        // When we later implement the login logic, this variable will store the login request result.
        boolean loggedIn = false;

        // Depending on the result of the login, we send a specific message to the view.
        if (loggedIn) {
            model.addAttribute("message", "You are now logged in.");
        } else {
            model.addAttribute("message", "Login failed");
        }

        return "login.html";
    }

}
