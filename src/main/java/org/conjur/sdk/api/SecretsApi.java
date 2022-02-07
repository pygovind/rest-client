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
@Component("org.conjur.sdk.api.SecretsApi")
public class SecretsApi {
    private ApiClient apiClient;

    public SecretsApi() {
        this(new ApiClient());
    }

    @Autowired
    public SecretsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Creates a secret value within the specified variable.
     * Creates a secret value within the specified Secret.   Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 
     * <p><b>201</b> - The secret value was added successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource - in almost all cases this should be &#x60;variable&#x60; (required)
     * @param identifier URL-encoded variable ID (required)
     * @param expirations Tells the server to reset the variables expiration date (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param body Secret data (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void createSecret(String account, String kind, String identifier, String expirations, String xRequestId, String body) throws RestClientException {
        createSecretWithHttpInfo(account, kind, identifier, expirations, xRequestId, body);
    }

    /**
     * Creates a secret value within the specified variable.
     * Creates a secret value within the specified Secret.   Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 
     * <p><b>201</b> - The secret value was added successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource - in almost all cases this should be &#x60;variable&#x60; (required)
     * @param identifier URL-encoded variable ID (required)
     * @param expirations Tells the server to reset the variables expiration date (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param body Secret data (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> createSecretWithHttpInfo(String account, String kind, String identifier, String expirations, String xRequestId, String body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling createSecret");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling createSecret");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling createSecret");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/secrets/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "expirations", expirations));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/octet-stream"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Fetches the value of a secret from the specified Secret.
     * Fetches the value of a secret from the specified Secret. The latest version will be retrieved unless the version parameter is specified. The twenty most recent secret versions are retained.  The secret data is returned in the response body.  Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 
     * <p><b>200</b> - The secret value was added successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource - in almost all cases this should be &#x60;variable&#x60; (required)
     * @param identifier URL-encoded variable ID (required)
     * @param version (**Optional**) Version you want to retrieve (Conjur keeps the last 20 versions of a secret) (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getSecret(String account, String kind, String identifier, Integer version, String xRequestId) throws RestClientException {
        return getSecretWithHttpInfo(account, kind, identifier, version, xRequestId).getBody();
    }

    /**
     * Fetches the value of a secret from the specified Secret.
     * Fetches the value of a secret from the specified Secret. The latest version will be retrieved unless the version parameter is specified. The twenty most recent secret versions are retained.  The secret data is returned in the response body.  Note: Conjur will allow you to add a secret to any resource, but the best practice is to store and retrieve secret data only using Secret resources. 
     * <p><b>200</b> - The secret value was added successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource - in almost all cases this should be &#x60;variable&#x60; (required)
     * @param identifier URL-encoded variable ID (required)
     * @param version (**Optional**) Version you want to retrieve (Conjur keeps the last 20 versions of a secret) (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getSecretWithHttpInfo(String account, String kind, String identifier, Integer version, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getSecret");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling getSecret");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling getSecret");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/secrets/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "version", version));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Fetch multiple secrets
     * Fetches multiple secret values in one invocation. It’s faster to fetch secrets in batches than to fetch them one at a time.
     * <p><b>200</b> - The batch secret values
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - At least one resource was unable to be found
     * <p><b>406</b> - Issue encoding secret into JSON format
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param variableIds Comma-delimited, URL-encoded resource IDs of the variables. (required)
     * @param acceptEncoding Set the encoding of the response object (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object getSecrets(String variableIds, String acceptEncoding, String xRequestId) throws RestClientException {
        return getSecretsWithHttpInfo(variableIds, acceptEncoding, xRequestId).getBody();
    }

    /**
     * Fetch multiple secrets
     * Fetches multiple secret values in one invocation. It’s faster to fetch secrets in batches than to fetch them one at a time.
     * <p><b>200</b> - The batch secret values
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - At least one resource was unable to be found
     * <p><b>406</b> - Issue encoding secret into JSON format
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param variableIds Comma-delimited, URL-encoded resource IDs of the variables. (required)
     * @param acceptEncoding Set the encoding of the response object (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> getSecretsWithHttpInfo(String variableIds, String acceptEncoding, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'variableIds' is set
        if (variableIds == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'variableIds' when calling getSecrets");
        }
        
        String path = apiClient.expandPath("/secrets", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "variable_ids", variableIds));

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
