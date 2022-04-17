package com.example.controllers;

import com.example.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Marking the class as a REST controller to add a bean in the Spring context and also inform the dispatcher servlet
 * not to look for a view when this method returns.
 */
@RestController
public class CountryController {

    /**
     * Mapping the controller's action to the HTTP GET method and /france path
     * @return  an instance of type {@link Country}.
     */
    @GetMapping("/france")
    public Country france() {
        Country c = Country.of("France", 67);
        return c;
    }


    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);

        return List.of(c1, c2);
    }
}
