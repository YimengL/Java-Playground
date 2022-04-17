package com.example.controllers;

import com.example.services.LoggedUserManagementService;
import com.example.services.LoginCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCountService loginCountService;

    /**
     * We auto-wire the {@link LoggedUserManagementService} bean to find out if the user already logged in.
     */
    @Autowired
    public MainController(LoggedUserManagementService loggedUserManagementService,
                          LoginCountService loginCountService) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCountService = loginCountService;
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
        int count = loginCountService.getCount();

        if (username == null) {
            // If the user is not logged in, we redirect the user to the login page.
            return "redirect:/";
        }

        // We send the username to the view.
        model.addAttribute("username", username);
        model.addAttribute("loginCount", count);
        // If the user is logged in, we return the view for the main page.
        return "main.html";
    }
}
