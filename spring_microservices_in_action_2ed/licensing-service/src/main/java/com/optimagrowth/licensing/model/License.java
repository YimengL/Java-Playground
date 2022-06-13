package com.optimagrowth.licensing.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * A Plain Old Java Object (POJO) that contains the license info
 */
@Getter @Setter @ToString
public class License {

    private int id;
    private String licenseId;
    private String description;
    private String organizationId;
    private String productName;
    private String licenseType;
}
