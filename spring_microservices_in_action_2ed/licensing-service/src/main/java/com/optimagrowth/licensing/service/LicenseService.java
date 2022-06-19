package com.optimagrowth.licensing.service;

import com.optimagrowth.licensing.model.License;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    @Autowired
    MessageSource messages;

    public License getLicense(String licenseId, String organizationId) {
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");

        return license;
    }

    /**
     * @param locale    Receives the locale as a method parameter.
     */
    public String createLicense(License license, String organizationId, Locale locale) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            // Sets the received locale to retrieve the specific message
            responseMessage = String.format(messages.getMessage("license.create.message", null, locale),
                    license.toString());
        }

        return responseMessage;
    }

    public String updateLicense(License license, String organizationId) {
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            // Sends a null locale to retrieve specific message
            responseMessage = String.format(messages.getMessage("license.update.message", null, null),
                            license.toString());
        }

        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        responseMessage = String.format(messages.getMessage("license.delete.message", null, null), licenseId,
                organizationId);
        return responseMessage;
    }
}
