package com.example.model;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


/**
 * We annotate the class with a stereotype annotation to tell Spring this is a bean.
 * We use the {@code @RequestScope} annotation to change the bean's scope to request scope. This way, Spring creates
 * a new instance of the class for every HTTP request.
 */
@Component
@RequestScope
public class LoginProcessor {

    // The bean stores the credentials as attributes
    private String username;
    private String password;

    /**
     * The bean defines a method for implementing the login logic.
     */
    public boolean login() {
        String username = this.getUsername();
        String password = this.getPassword();

        if ("natalie".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
