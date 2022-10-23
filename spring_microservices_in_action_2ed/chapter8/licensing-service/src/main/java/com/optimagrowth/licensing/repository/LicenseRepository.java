package com.optimagrowth.licensing.repository;

import com.optimagrowth.licensing.model.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Tells Spring Boot that this is a JPA repository class. Annotation is optional when we extend from a CrudRepository
@Repository
// Extends Spring CrudRepository
public interface LicenseRepository extends CrudRepository<License, String> {
    // Parses query methods into a SELECT ... FROM query
    public List<License> findByOrganizationId(String organizationId);

    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
