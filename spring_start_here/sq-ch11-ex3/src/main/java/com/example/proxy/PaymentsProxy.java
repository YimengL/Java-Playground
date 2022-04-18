package com.example.proxy;

import com.example.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Component
public class PaymentsProxy {

    private final WebClient webClient;

    /**
     * We take the base URL from the properties file.
     */
    @Value("${name.service.url}")
    private String url;

    @Autowired
    public PaymentsProxy(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        return webClient.post()// We specify the HTTP method we use when making the call
                .uri(url + "/payment") // We specify the URI for the call
                .header("requestId", requestId) // We add the HTTP header value to the request. You can call
                // the header() method multiple times if you want to add more headers
                .body(Mono.just(payment), Payment.class) // We provide the HTTP request body
                .retrieve() // We send the HTTP request and obtain the HTTP response
                .bodyToMono(Payment.class); // We get the HTTP response body
    }
}
