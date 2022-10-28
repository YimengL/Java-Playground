package com.optimagrowth.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;


@Configuration
public class ResponseFilter {

    private static final Logger logger = LoggerFactory.getLogger(ResponseFilter.class);

    @Autowired
    FilterUtils filterUtils;

    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
                // Grabs the correlation ID that was passed in to the original HTTP request
                String correlationId = filterUtils.getCorrelationId(requestHeaders);
                logger.debug("Adding the correlation id to the outbound headers. {}", correlationId);

                exchange.getResponse().getHeaders().add(FilterUtils.CORRELATION_ID, correlationId);

                // Logs the outgoing request URI so that you have "bookends" that show the incoming and outgoing entry
                // of the user's request into the gateway
                logger.debug("Completing outing request for {}.", exchange.getRequest().getURI());
            }));
        };
    }
}
