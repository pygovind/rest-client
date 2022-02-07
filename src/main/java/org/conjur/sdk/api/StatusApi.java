package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.AuthenticatorStatus;
import org.conjur.sdk.model.AuthenticatorsResponse;
import org.conjur.sdk.model.WhoAmI;

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
@Component("org.conjur.sdk.api.StatusApi")
public class StatusApi {
    private ApiClient apiClient;

    public StatusApi() {
        this(new ApiClient());
    }

    @Autowired
    public StatusApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Details about which authenticators are on the Conjur Server
     * Response contains three members: installed, configured, and enabled.  installed: The authenticator is implemented in Conjur and is available for configuration configured: The authenticator has a webservice in the DB that was loaded by policy enabled: The authenticator is enabled (in the DB or in the ENV) and is ready for authentication 
     * <p><b>200</b> - Details about authenticators for this Conjur server
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return AuthenticatorsResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AuthenticatorsResponse getAuthenticators(String xRequestId) throws RestClientException {
        return getAuthenticatorsWithHttpInfo(xRequestId).getBody();
    }

    /**
     * Details about which authenticators are on the Conjur Server
     * Response contains three members: installed, configured, and enabled.  installed: The authenticator is implemented in Conjur and is available for configuration configured: The authenticator has a webservice in the DB that was loaded by policy enabled: The authenticator is enabled (in the DB or in the ENV) and is ready for authentication 
     * <p><b>200</b> - Details about authenticators for this Conjur server
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;AuthenticatorsResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AuthenticatorsResponse> getAuthenticatorsWithHttpInfo(String xRequestId) throws RestClientException {
        Object postBody = null;
        
        String path = apiClient.expandPath("/authenticators", Collections.<String, Object>emptyMap());

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
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth", "conjurAuth", "conjurKubernetesMutualTls" };

        ParameterizedTypeReference<AuthenticatorsResponse> returnType = new ParameterizedTypeReference<AuthenticatorsResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Details whether an authentication service has been configured properly
     * Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  This operation only supports the GCP authenticator  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 
     * <p><b>200</b> - The response contains info about the result
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The service was not found
     * <p><b>500</b> - The response contains info about the result
     * <p><b>501</b> - The response contains info about the result
     * @param account The organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return AuthenticatorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AuthenticatorStatus getGCPAuthenticatorStatus(String account, String xRequestId) throws RestClientException {
        return getGCPAuthenticatorStatusWithHttpInfo(account, xRequestId).getBody();
    }

    /**
     * Details whether an authentication service has been configured properly
     * Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  This operation only supports the GCP authenticator  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 
     * <p><b>200</b> - The response contains info about the result
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The service was not found
     * <p><b>500</b> - The response contains info about the result
     * <p><b>501</b> - The response contains info about the result
     * @param account The organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;AuthenticatorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AuthenticatorStatus> getGCPAuthenticatorStatusWithHttpInfo(String account, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getGCPAuthenticatorStatus");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn-gcp/{account}/status", uriVariables);

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
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<AuthenticatorStatus> returnType = new ParameterizedTypeReference<AuthenticatorStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Details whether an authentication service has been configured properly
     * Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  Supported Authenticators:   - Azure   - OIDC  Not Supported:   - AWS IAM   - Kubernetes   - LDAP  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 
     * <p><b>200</b> - The response contains info about the result
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The service was not found
     * <p><b>500</b> - The response contains info about the result
     * <p><b>501</b> - The response contains info about the result
     * @param authenticator The type of authenticator (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account The organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return AuthenticatorStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public AuthenticatorStatus getServiceAuthenticatorStatus(String authenticator, String serviceId, String account, String xRequestId) throws RestClientException {
        return getServiceAuthenticatorStatusWithHttpInfo(authenticator, serviceId, account, xRequestId).getBody();
    }

    /**
     * Details whether an authentication service has been configured properly
     * Once the status webservice has been properly configured and the relevant user groups have been given permissions to access the status webservice, the users in those groups can check the status of the authenticator.  Supported Authenticators:   - Azure   - OIDC  Not Supported:   - AWS IAM   - Kubernetes   - LDAP  See [Conjur Documentation](https://docs.conjur.org/Latest/en/Content/Integrations/Authn-status.htm) for details on setting up the authenticator status webservice. 
     * <p><b>200</b> - The response contains info about the result
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The service was not found
     * <p><b>500</b> - The response contains info about the result
     * <p><b>501</b> - The response contains info about the result
     * @param authenticator The type of authenticator (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account The organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;AuthenticatorStatus&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<AuthenticatorStatus> getServiceAuthenticatorStatusWithHttpInfo(String authenticator, String serviceId, String account, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authenticator' is set
        if (authenticator == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authenticator' when calling getServiceAuthenticatorStatus");
        }
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getServiceAuthenticatorStatus");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getServiceAuthenticatorStatus");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("authenticator", authenticator);
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/{authenticator}/{service_id}/{account}/status", uriVariables);

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
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<AuthenticatorStatus> returnType = new ParameterizedTypeReference<AuthenticatorStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Provides information about the client making an API request.
     * WhoAmI provides information about the client making an API request. It can be used to help troubleshoot configuration by verifying authentication and the client IP address for audit and network access restrictions. For more information, see Host Attributes. 
     * <p><b>200</b> - Details about the client making the request
     * <p><b>401</b> - Authentication information is missing or invalid
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return WhoAmI
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public WhoAmI whoAmI(String xRequestId) throws RestClientException {
        return whoAmIWithHttpInfo(xRequestId).getBody();
    }

    /**
     * Provides information about the client making an API request.
     * WhoAmI provides information about the client making an API request. It can be used to help troubleshoot configuration by verifying authentication and the client IP address for audit and network access restrictions. For more information, see Host Attributes. 
     * <p><b>200</b> - Details about the client making the request
     * <p><b>401</b> - Authentication information is missing or invalid
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;WhoAmI&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<WhoAmI> whoAmIWithHttpInfo(String xRequestId) throws RestClientException {
        Object postBody = null;
        
        String path = apiClient.expandPath("/whoami", Collections.<String, Object>emptyMap());

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
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<WhoAmI> returnType = new ParameterizedTypeReference<WhoAmI>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
