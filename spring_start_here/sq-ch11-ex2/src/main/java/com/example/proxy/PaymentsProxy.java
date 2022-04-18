package com.example.proxy;

import com.example.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;


@Component
public class PaymentsProxy {

    private final RestTemplate rest;

    /**
     * We take the URL to the payment service from the properties file.
     */
    @Value("${name.service.url}")
    private String paymentServiceUrl;

    /**
     * @param rest  We inject the {@code RestTemplate} from the Spring context using construction DI.
     */
    @Autowired
    public PaymentsProxy(RestTemplate rest) {
        this.rest = rest;
    }

    /**
     * @return  We return the HTTP response body.
     */
    public Payment createPayment(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        // We build the HttpHeaders object to define the HTTp request header.
        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        // We build the HttpEntity object to define request data.
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        // We send the HTTP request and retrieve the data on the HTTP response.
        ResponseEntity<Payment> response = rest.exchange(uri, HttpMethod.POST, httpEntity, Payment.class);

        return response.getBody();
    }
}
