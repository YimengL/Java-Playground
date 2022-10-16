package com.optimagrowth.licensing.service.client;

import com.optimagrowth.licensing.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("organization-service") // Identifies your service to Feign
public interface OrganizationFeignClient {

    // Defines the path and action to your endpoint
    @RequestMapping(method = RequestMethod.GET,
            value = "/v1/organization/{organizationId}",
            consumes = "application/json")
    // Defines the parameters passed into the endpoint
    Organization getOrganization(@PathVariable("organizationId") String organizationId);
}
