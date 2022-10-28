package com.optimagrowth.licensing.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class UserContextInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(UserContextInterceptor.class);

    /**
     * Invokes intercept() method before the actual HTTP service call occurs by the
     * {@link org.springframework.web.client.RestTemplate}.
     */
    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(UserContext.CORRELATION_ID, UserContextHolder.getContext().getCorrelationId());
        headers.add(UserContext.AUTH_TOKEN, UserContextHolder.getContext().getAuthToken());
        logger.info("Interceptor test, corr id: {}, auth token: {}", headers.get(UserContext.CORRELATION_ID),
                headers.get(UserContext.AUTH_TOKEN));
        return execution.execute(request, body);
    }
}
