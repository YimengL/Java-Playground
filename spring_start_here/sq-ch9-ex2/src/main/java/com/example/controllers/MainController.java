package com.example.controllers;

import com.example.services.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;

    /**
     * We auto-wire the {@link LoggedUserManagementService} bean to find out if the user already logged in.
     */
    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout,
                       Model model) {
        // If the logout parameter is present, we erase the username from the LoggedUserManagementService bean.
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        // We take the username value, which should be different than null if someone logged in.
        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            // If the user is not logged in, we redirect the user to the login page.
            return "redirect:/";
        }

        // We send the username to the view.
        model.addAttribute("username", username);
        // If the user is logged in, we return the view for the main page.
        return "main.html";
    }
}
