package com .example.controllers;


import com.example.model.Product;
import com.example.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductController {


    private final ProductService productService;


    // We use DI through the Controller's constructor parameters to get service bean from the Spring context.
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * {@code @GetMapping} maps the HTTP GET request with a specific path to the controller's action.
     * @param model     We define a {@code Model} parameter that we use to send the data to the view.
     */
    @GetMapping("/products")
    public String viewProducts(Model model) {
        // We get the product list from the service.
        var products = productService.findAll();

        // We send the product list to the view.
        model.addAttribute("products", products);

        return "products.html";
    }


    /**
     * {@code @PostMapping} maps the HTTP POST requests with a specific path to the controller's action.
     * We get the name and price for the product to add using request parameters.
     */
    @PostMapping("/products")
    public String addProduct(
            Product p,
            Model model) {
        productService.addProduct(p);

        // We get the list of products and send it to the view
        var products = productService.findAll();
        model.addAttribute("products", products);

        // We return the name of the view to be rendered.
        return "products.html";
    }

}
