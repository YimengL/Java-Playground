package com.optimagrowth.licensing.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

/**
 * A Plain Old Java Object (POJO) that contains the license info
 */
@Getter @Setter @ToString
@Entity // Tells Spring that this is a JPA class
@Table(name = "licenses") // Map to the database table
public class License extends RepresentationModel<License> {

    @Id // Marks this field as a primary key
    @Column(name = "license_id", nullable = false) // Maps the field to a specific database column
    private String licenseId;
    private String description;
    @Column(name = "organization_id", nullable = false)
    private String organizationId;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "license_type", nullable = false)
    private String licenseType;
    @Column(name = "comment")
    private String comment;
    @Transient
    private String organizationName;
    @Transient
    private String contactName;
    @Transient
    private String contactPhone;
    @Transient
    private String contactEmail;

    public License withComment(String comment) {
        this.setComment(comment);
        return this;
    }
}
