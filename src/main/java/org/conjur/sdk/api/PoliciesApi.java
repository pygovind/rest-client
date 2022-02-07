package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.LoadedPolicy;

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
@Component("org.conjur.sdk.api.PoliciesApi")
public class PoliciesApi {
    private ApiClient apiClient;

    public PoliciesApi() {
        this(new ApiClient());
    }

    @Autowired
    public PoliciesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Adds data to the existing Conjur policy.
     * Adds data to the existing Conjur policy. Deletions are not allowed. Any policy objects that exist on the server but are omitted from the policy file will not be deleted and any explicit deletions in the policy file will result in an error.  ##### Permissions required  &#x60;create&#x60; privilege on the policy.\&quot; 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to update (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return LoadedPolicy
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LoadedPolicy loadPolicy(String account, String identifier, String body, String xRequestId) throws RestClientException {
        return loadPolicyWithHttpInfo(account, identifier, body, xRequestId).getBody();
    }

    /**
     * Adds data to the existing Conjur policy.
     * Adds data to the existing Conjur policy. Deletions are not allowed. Any policy objects that exist on the server but are omitted from the policy file will not be deleted and any explicit deletions in the policy file will result in an error.  ##### Permissions required  &#x60;create&#x60; privilege on the policy.\&quot; 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to update (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;LoadedPolicy&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<LoadedPolicy> loadPolicyWithHttpInfo(String account, String identifier, String body, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling loadPolicy");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling loadPolicy");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling loadPolicy");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/policies/{account}/policy/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-yaml", "text/plain", "text/x-yaml", "text/yaml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<LoadedPolicy> returnType = new ParameterizedTypeReference<LoadedPolicy>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Loads or replaces a Conjur policy document.
     * Loads or replaces a Conjur policy document.  **Any policy data which already exists on the server but is not explicitly specified in the new policy file will be deleted!**. 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to load (root if no root policy has been loaded yet) (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return LoadedPolicy
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LoadedPolicy replacePolicy(String account, String identifier, String body, String xRequestId) throws RestClientException {
        return replacePolicyWithHttpInfo(account, identifier, body, xRequestId).getBody();
    }

    /**
     * Loads or replaces a Conjur policy document.
     * Loads or replaces a Conjur policy document.  **Any policy data which already exists on the server but is not explicitly specified in the new policy file will be deleted!**. 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to load (root if no root policy has been loaded yet) (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;LoadedPolicy&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<LoadedPolicy> replacePolicyWithHttpInfo(String account, String identifier, String body, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling replacePolicy");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling replacePolicy");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling replacePolicy");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/policies/{account}/policy/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-yaml", "text/plain", "text/x-yaml", "text/yaml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<LoadedPolicy> returnType = new ParameterizedTypeReference<LoadedPolicy>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Modifies an existing Conjur policy.
     * Modifies an existing Conjur policy. Data may be explicitly deleted using the &#x60;!delete&#x60;, &#x60;!revoke&#x60;, and &#x60;!deny&#x60; statements. Unlike &#x60;replace&#x60; mode, no data is ever implicitly deleted.  ##### Permissions required 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to update (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return LoadedPolicy
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public LoadedPolicy updatePolicy(String account, String identifier, String body, String xRequestId) throws RestClientException {
        return updatePolicyWithHttpInfo(account, identifier, body, xRequestId).getBody();
    }

    /**
     * Modifies an existing Conjur policy.
     * Modifies an existing Conjur policy. Data may be explicitly deleted using the &#x60;!delete&#x60;, &#x60;!revoke&#x60;, and &#x60;!deny&#x60; statements. Unlike &#x60;replace&#x60; mode, no data is ever implicitly deleted.  ##### Permissions required 
     * <p><b>201</b> - Decsribes new data created by a successful policy load
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>409</b> - Similar operation already in progress, retry after a delay
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param identifier ID of the policy to update (required)
     * @param body Policy (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;LoadedPolicy&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<LoadedPolicy> updatePolicyWithHttpInfo(String account, String identifier, String body, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling updatePolicy");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling updatePolicy");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updatePolicy");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/policies/{account}/policy/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-yaml", "text/plain", "text/x-yaml", "text/yaml"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<LoadedPolicy> returnType = new ParameterizedTypeReference<LoadedPolicy>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
