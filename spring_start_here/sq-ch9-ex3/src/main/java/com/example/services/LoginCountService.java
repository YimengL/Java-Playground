package com.example.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;


/**
 * The {@code @ApplicationScope} annotation changes the scope of this bean to the application scope.
 */
@Service
@ApplicationScope
public class LoginCountService {

    private int count;

    public void increment() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
