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

import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for PublicKeysApi
 */
@Ignore
public class PublicKeysApiTest {

    private final PublicKeysApi api = new PublicKeysApi();

    
    /**
     * Shows all public keys for a resource.
     *
     * Shows all public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Returns an empty string if the resource does not exist, to prevent attackers from determining whether a resource exists. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void showPublicKeysTest() {
        String account = null;
        String kind = null;
        String identifier = null;
        String xRequestId = null;
        String response = api.showPublicKeys(account, kind, identifier, xRequestId);

        // TODO: test validations
    }
    
}