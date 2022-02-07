package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.CertificateJson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
@Component("org.conjur.sdk.api.CertificateAuthorityApi")
public class CertificateAuthorityApi {
    private ApiClient apiClient;

    public CertificateAuthorityApi() {
        this(new ApiClient());
    }

    @Autowired
    public CertificateAuthorityApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets a signed certificate from the configured Certificate Authority service.
     * Gets a signed certificate from the configured Certificate Authority service.  The request must include a valid Certificate Signing Request, and a desired TTL in ISO 8601 format.  *** IMPORTANT *** This endpoint is part of an early implementation of support for using Conjur as a certificate authority, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future. 
     * <p><b>201</b> - The response body is the newly signed certificate
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - Either           - The authenticated role is not a Host role, - The authenticated Host does not have &#x60;sign&#x60; privilege for the CA service, or - The authenticated Host ID does not match the of the CSR Common Name (CN). 
     * <p><b>404</b> - CA Service with the given ID does not exist
     * @param account Organization account name (required)
     * @param serviceId Name of the Certificate Authority service (required)
     * @param csr  (required)
     * @param ttl  (required)
     * @param accept Setting the Accept header to &#x60;application/x-pem-file&#x60; allows Conjur to respond with a formatted certificate (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return CertificateJson
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CertificateJson sign(String account, String serviceId, String csr, String ttl, String accept, String xRequestId) throws RestClientException {
        return signWithHttpInfo(account, serviceId, csr, ttl, accept, xRequestId).getBody();
    }

    /**
     * Gets a signed certificate from the configured Certificate Authority service.
     * Gets a signed certificate from the configured Certificate Authority service.  The request must include a valid Certificate Signing Request, and a desired TTL in ISO 8601 format.  *** IMPORTANT *** This endpoint is part of an early implementation of support for using Conjur as a certificate authority, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future. 
     * <p><b>201</b> - The response body is the newly signed certificate
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - Either           - The authenticated role is not a Host role, - The authenticated Host does not have &#x60;sign&#x60; privilege for the CA service, or - The authenticated Host ID does not match the of the CSR Common Name (CN). 
     * <p><b>404</b> - CA Service with the given ID does not exist
     * @param account Organization account name (required)
     * @param serviceId Name of the Certificate Authority service (required)
     * @param csr  (required)
     * @param ttl  (required)
     * @param accept Setting the Accept header to &#x60;application/x-pem-file&#x60; allows Conjur to respond with a formatted certificate (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;CertificateJson&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CertificateJson> signWithHttpInfo(String account, String serviceId, String csr, String ttl, String accept, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling sign");
        }
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling sign");
        }
        
        // verify the required parameter 'csr' is set
        if (csr == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'csr' when calling sign");
        }
        
        // verify the required parameter 'ttl' is set
        if (ttl == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'ttl' when calling sign");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("service_id", serviceId);
        String path = apiClient.expandPath("/ca/{account}/{service_id}/sign", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (accept != null)
        headerParams.add("Accept", apiClient.parameterToString(accept));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (csr != null)
            formParams.add("csr", csr);
        if (ttl != null)
            formParams.add("ttl", ttl);

        final String[] accepts = { 
            "application/json", "application/x-pem-file"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<CertificateJson> returnType = new ParameterizedTypeReference<CertificateJson>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
