package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.CreateHost;

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
@Component("org.conjur.sdk.api.HostFactoryApi")
public class HostFactoryApi {
    private ApiClient apiClient;

    public HostFactoryApi() {
        this(new ApiClient());
    }

    @Autowired
    public HostFactoryApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Creates a Host using the Host Factory.
     * Creates a Host using the Host Factory and returns a JSON description of it.  Requires a host factory token, which can be created using the create tokens API. In practice, this token is usually provided automatically as part of Conjur integration with your host provisioning infrastructure.  Note: If the token was created with a CIDR restriction, you must make this API request from a whitelisted address. 
     * <p><b>201</b> - The response body contains the newly-created host
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param id Identifier of the host to be created. It will be created within the account of the host factory. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param annotations Annotations to apply to the new host (optional)
     * @return CreateHost
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreateHost createHost(String id, String xRequestId, Object annotations) throws RestClientException {
        return createHostWithHttpInfo(id, xRequestId, annotations).getBody();
    }

    /**
     * Creates a Host using the Host Factory.
     * Creates a Host using the Host Factory and returns a JSON description of it.  Requires a host factory token, which can be created using the create tokens API. In practice, this token is usually provided automatically as part of Conjur integration with your host provisioning infrastructure.  Note: If the token was created with a CIDR restriction, you must make this API request from a whitelisted address. 
     * <p><b>201</b> - The response body contains the newly-created host
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param id Identifier of the host to be created. It will be created within the account of the host factory. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param annotations Annotations to apply to the new host (optional)
     * @return ResponseEntity&lt;CreateHost&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CreateHost> createHostWithHttpInfo(String id, String xRequestId, Object annotations) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling createHost");
        }
        
        String path = apiClient.expandPath("/host_factories/hosts", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (annotations != null)
            formParams.add("annotations", annotations);
        if (id != null)
            formParams.add("id", id);

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<CreateHost> returnType = new ParameterizedTypeReference<CreateHost>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Creates one or more host identity tokens.
     * Creates one or more tokens which can be used to bootstrap host identity. Responds with a JSON document containing the tokens and their restrictions.  If the tokens are created with a CIDR restriction, Conjur will only accept them from the whitelisted IP ranges.  ##### Permissions required # &#x60;execute&#x60; privilege on the Host Factory.\&quot; 
     * <p><b>200</b> - Zero or more tokens were created and delivered in the response body
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param expiration &#x60;ISO 8601 datetime&#x60; denoting a requested expiration time. (required)
     * @param hostFactory Fully qualified host factory ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param cidr Number of host tokens to create (optional)
     * @param count Number of host tokens to create (optional)
     * @return List&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Object> createToken(String expiration, String hostFactory, String xRequestId, List<String> cidr, Integer count) throws RestClientException {
        return createTokenWithHttpInfo(expiration, hostFactory, xRequestId, cidr, count).getBody();
    }

    /**
     * Creates one or more host identity tokens.
     * Creates one or more tokens which can be used to bootstrap host identity. Responds with a JSON document containing the tokens and their restrictions.  If the tokens are created with a CIDR restriction, Conjur will only accept them from the whitelisted IP ranges.  ##### Permissions required # &#x60;execute&#x60; privilege on the Host Factory.\&quot; 
     * <p><b>200</b> - Zero or more tokens were created and delivered in the response body
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param expiration &#x60;ISO 8601 datetime&#x60; denoting a requested expiration time. (required)
     * @param hostFactory Fully qualified host factory ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param cidr Number of host tokens to create (optional)
     * @param count Number of host tokens to create (optional)
     * @return ResponseEntity&lt;List&lt;Object&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Object>> createTokenWithHttpInfo(String expiration, String hostFactory, String xRequestId, List<String> cidr, Integer count) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'expiration' is set
        if (expiration == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'expiration' when calling createToken");
        }
        
        // verify the required parameter 'hostFactory' is set
        if (hostFactory == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'hostFactory' when calling createToken");
        }
        
        String path = apiClient.expandPath("/host_factory_tokens", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (cidr != null)
            formParams.put("cidr", cidr);
        if (count != null)
            formParams.add("count", count);
        if (expiration != null)
            formParams.add("expiration", expiration);
        if (hostFactory != null)
            formParams.add("host_factory", hostFactory);

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<List<Object>> returnType = new ParameterizedTypeReference<List<Object>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Revokes a token, immediately disabling it.
     * Revokes a token, immediately disabling it.  ##### Permissions required  &#x60;update&#x60; privilege on the host factory.\&quot; 
     * <p><b>204</b> - Token was successfully revoked
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param token The host factory token to revoke (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void revokeToken(String token, String xRequestId) throws RestClientException {
        revokeTokenWithHttpInfo(token, xRequestId);
    }

    /**
     * Revokes a token, immediately disabling it.
     * Revokes a token, immediately disabling it.  ##### Permissions required  &#x60;update&#x60; privilege on the host factory.\&quot; 
     * <p><b>204</b> - Token was successfully revoked
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param token The host factory token to revoke (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> revokeTokenWithHttpInfo(String token, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'token' is set
        if (token == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'token' when calling revokeToken");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("token", token);
        String path = apiClient.expandPath("/host_factory_tokens/{token}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
