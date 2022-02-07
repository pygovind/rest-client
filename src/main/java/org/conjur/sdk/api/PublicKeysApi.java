package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;


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
@Component("org.conjur.sdk.api.PublicKeysApi")
public class PublicKeysApi {
    private ApiClient apiClient;

    public PublicKeysApi() {
        this(new ApiClient());
    }

    @Autowired
    public PublicKeysApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Shows all public keys for a resource.
     * Shows all public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Returns an empty string if the resource does not exist, to prevent attackers from determining whether a resource exists. 
     * <p><b>200</b> - Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the resource for which to get the information about (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String showPublicKeys(String account, String kind, String identifier, String xRequestId) throws RestClientException {
        return showPublicKeysWithHttpInfo(account, kind, identifier, xRequestId).getBody();
    }

    /**
     * Shows all public keys for a resource.
     * Shows all public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Returns an empty string if the resource does not exist, to prevent attackers from determining whether a resource exists. 
     * <p><b>200</b> - Public keys for a resource as newline delimited string for compatibility with the authorized_keys SSH format. Empty string if the resource does not exist
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the resource for which to get the information about (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> showPublicKeysWithHttpInfo(String account, String kind, String identifier, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling showPublicKeys");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling showPublicKeys");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling showPublicKeys");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/public_keys/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth", "conjurAuth", "conjurKubernetesMutualTls" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
