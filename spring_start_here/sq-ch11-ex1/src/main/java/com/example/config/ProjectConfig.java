package com.example.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


/**
 * We enable the {@code OpenFeign} clients and tell the {@code OpenFeign} dependency where to search for the proxy
 * contract.
 */
@Configuration
@EnableFeignClients(basePackages = "com.example.proxy")
public class ProjectConfig {
}
