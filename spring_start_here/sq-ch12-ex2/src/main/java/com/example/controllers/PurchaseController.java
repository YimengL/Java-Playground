package com.example.controllers;

import com.example.model.Purchase;
import com.example.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    /**
     * @param purchaseRepository    We use constructor dependency injection to get the repository object from the Spring
     *                              context.
     */
    @Autowired
    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    /**
     * We implement an endpoint a client calls to store a purchase record in the database. We use the repository
     * storePurchase() method to persist the data the controller's action gets from HTTP request body.
     */
    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }

    /**
     * We implement an endpoint the client class to get all the records from the purchase table. The controller's action
     * uses the repository's method to get the data from the database and returns the data to the client in the HTTP
     * response body.
     */
    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
