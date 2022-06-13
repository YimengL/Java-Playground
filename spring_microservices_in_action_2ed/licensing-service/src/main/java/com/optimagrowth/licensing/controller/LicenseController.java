package com.optimagrowth.licensing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Tells Spring Boot that this is a REST-based service and it will automatically serialize/deserialize service
// requests/responses via JSON
@RestController
// Exposes all the HTTP endpoints in this class with a prefix of /v1/organization/{organizationId}/license
@RequestMapping(value = "v1/organization/{organizationId}/license")
public class LicenseController {
}
