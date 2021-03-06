/*
 * Conjur
 * This is an API definition for CyberArk Conjur Open Source. You can find out more at [Conjur.org](https://www.conjur.org/).
 *
 * The version of the OpenAPI document: 5.3.0
 * Contact: conj_maintainers@cyberark.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.conjur.sdk.api;

import org.conjur.sdk.model.CertificateJson;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for CertificateAuthorityApi
 */
@Ignore
public class CertificateAuthorityApiTest {

    private final CertificateAuthorityApi api = new CertificateAuthorityApi();

    
    /**
     * Gets a signed certificate from the configured Certificate Authority service.
     *
     * Gets a signed certificate from the configured Certificate Authority service.  The request must include a valid Certificate Signing Request, and a desired TTL in ISO 8601 format.  *** IMPORTANT *** This endpoint is part of an early implementation of support for using Conjur as a certificate authority, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void signTest() {
        String account = null;
        String serviceId = null;
        String csr = null;
        String ttl = null;
        String accept = null;
        String xRequestId = null;
        CertificateJson response = api.sign(account, serviceId, csr, ttl, accept, xRequestId);

        // TODO: test validations
    }
    
}
