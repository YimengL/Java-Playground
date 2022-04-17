package com.example.services;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

/**
 * We add the {@code @Service} stereotype annotation to instruct Spring to manage this class as a bean in its context.
 * We use the {@code @SessionScope} annotation to change the scope of the bean to session.
 */
@Service
@SessionScope
public class LoggedUserManagementService {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
