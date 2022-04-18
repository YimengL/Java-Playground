package com.example.controllers;

import com.example.exceptions.NotEnoughMoneyException;
import com.example.model.ErrorDetails;
import com.example.model.PaymentDetails;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment() {
        try {
            // We try calling the processPayment() method of the service
            PaymentDetails paymentDetails = paymentService.processPayment();

            // If calling the service method succeeds, we return an HTTP response withy status Accept and the
            // PaymentDetails instance as a response body
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(paymentDetails);
        } catch (NotEnoughMoneyException e) {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setMessage("Not enough money to make the payment.");

            // If an exception of type NotEnoughMoneyException is thrown, we return an HTTP response with status Bad
            // Request and an ErrorDetails instance as a body.
            return ResponseEntity
                    .badRequest()
                    .body(errorDetails);
        }

    }
}
