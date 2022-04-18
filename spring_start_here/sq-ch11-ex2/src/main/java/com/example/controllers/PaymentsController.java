package com.example.controllers;

import com.example.model.Payment;
import com.example.proxy.PaymentsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentsController {

    private final PaymentsProxy paymentsProxy;

    @Autowired
    public PaymentsController(PaymentsProxy paymentsProxy) {
        this.paymentsProxy = paymentsProxy;
    }

    /**
     * We define a controller action and map it to the /payment path
     *
     * @param payment   We get the payment data as a request body
     * @return  We call the proxy method, which in turn calls the endpoint of the payments service. We get the response
     *          body and return body to the client.
     */
    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentsProxy.createPayment(payment);
    }
}
