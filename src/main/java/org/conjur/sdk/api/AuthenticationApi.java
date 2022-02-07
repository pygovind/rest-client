package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.ServiceAuthenticators;

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
@Component("org.conjur.sdk.api.AuthenticationApi")
public class AuthenticationApi {
    private ApiClient apiClient;

    public AuthenticationApi() {
        this(new ApiClient());
    }

    @Autowired
    public AuthenticationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Changes a user’s password.
     * You must provide the login name and current password or API key of the user whose password is to be updated in an HTTP Basic Authentication header. Also replaces the user’s API key with a new securely generated random value. You can fetch the new API key using the Login method.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords. They authenticate using their API keys, while passwords are only used by human users. 
     * <p><b>204</b> - The password has been changed
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param body New password (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void changePassword(String account, String body, String xRequestId) throws RestClientException {
        changePasswordWithHttpInfo(account, body, xRequestId);
    }

    /**
     * Changes a user’s password.
     * You must provide the login name and current password or API key of the user whose password is to be updated in an HTTP Basic Authentication header. Also replaces the user’s API key with a new securely generated random value. You can fetch the new API key using the Login method.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords. They authenticate using their API keys, while passwords are only used by human users. 
     * <p><b>204</b> - The password has been changed
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param body New password (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> changePasswordWithHttpInfo(String account, String body, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling changePassword");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling changePassword");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn/{account}/password", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "text/plain"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Enables or disables authenticator defined without service_id.
     * Allows you to either enable or disable a given authenticator that does not have service_id (For example: authn-gcp).  When you enable or disable an authenticator via this endpoint, the status of the authenticator is stored in the Conjur database. The enablement status of the authenticator service may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 
     * <p><b>204</b> - The config was updated properly
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param authenticator The authenticator to update (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param enabled  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void enableAuthenticator(ServiceAuthenticators authenticator, String account, String xRequestId, Boolean enabled) throws RestClientException {
        enableAuthenticatorWithHttpInfo(authenticator, account, xRequestId, enabled);
    }

    /**
     * Enables or disables authenticator defined without service_id.
     * Allows you to either enable or disable a given authenticator that does not have service_id (For example: authn-gcp).  When you enable or disable an authenticator via this endpoint, the status of the authenticator is stored in the Conjur database. The enablement status of the authenticator service may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 
     * <p><b>204</b> - The config was updated properly
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param authenticator The authenticator to update (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param enabled  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> enableAuthenticatorWithHttpInfo(ServiceAuthenticators authenticator, String account, String xRequestId, Boolean enabled) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authenticator' is set
        if (authenticator == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authenticator' when calling enableAuthenticator");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling enableAuthenticator");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("authenticator", authenticator);
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/{authenticator}/{account}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (enabled != null)
            formParams.add("enabled", enabled);

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth", "conjurAuth", "conjurKubernetesMutualTls" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Enables or disables authenticator service instances.
     * Allows you to either enable or disable a given authenticator service instance.  When you enable or disable an authenticator service instance via this endpoint, the status of the authenticator service instance is stored in the Conjur database. The enablement status of the authenticator service instance may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service instance is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 
     * <p><b>204</b> - The config was updated properly
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param authenticator The authenticator to update (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param enabled  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void enableAuthenticatorInstance(ServiceAuthenticators authenticator, String serviceId, String account, String xRequestId, Boolean enabled) throws RestClientException {
        enableAuthenticatorInstanceWithHttpInfo(authenticator, serviceId, account, xRequestId, enabled);
    }

    /**
     * Enables or disables authenticator service instances.
     * Allows you to either enable or disable a given authenticator service instance.  When you enable or disable an authenticator service instance via this endpoint, the status of the authenticator service instance is stored in the Conjur database. The enablement status of the authenticator service instance may be overridden by setting the &#x60;CONJUR_AUTHENTICATORS&#x60; environment variable on the Conjur server; in the case where this environment variable is set, the database record of whether the authenticator service instance is enabled will be ignored.  **This endpoint is part of an early implementation of support for enabling Conjur authenticators via the API, and is currently available at the Community (or early alpha) level. This endpoint is still subject to breaking changes in the future.** 
     * <p><b>204</b> - The config was updated properly
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param authenticator The authenticator to update (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param enabled  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> enableAuthenticatorInstanceWithHttpInfo(ServiceAuthenticators authenticator, String serviceId, String account, String xRequestId, Boolean enabled) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'authenticator' is set
        if (authenticator == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'authenticator' when calling enableAuthenticatorInstance");
        }
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling enableAuthenticatorInstance");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling enableAuthenticatorInstance");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("authenticator", authenticator);
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/{authenticator}/{service_id}/{account}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (enabled != null)
            formParams.add("enabled", enabled);

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the API key of a user given the username and password via HTTP Basic Authentication. 
     * Passwords are stored in the Conjur database using &#x60;bcrypt&#x60; with a work factor of 12. Therefore, login is a fairly expensive operation. However, once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords and do not need to use this endpoint. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAPIKey(String account, String xRequestId) throws RestClientException {
        return getAPIKeyWithHttpInfo(account, xRequestId).getBody();
    }

    /**
     * Gets the API key of a user given the username and password via HTTP Basic Authentication. 
     * Passwords are stored in the Conjur database using &#x60;bcrypt&#x60; with a work factor of 12. Therefore, login is a fairly expensive operation. However, once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  Note that machine roles (Hosts) do not have passwords and do not need to use this endpoint. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAPIKeyWithHttpInfo(String account, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAPIKey");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn/{account}/login", uriVariables);

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

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets the Conjur API key of a user given the LDAP username and password via HTTP Basic Authentication. 
     * Exchange your LDAP credentials for a Conjur API key. Once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the LDAP username, a literal colon character &#39;:&#39;,    and the password to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAPIKeyViaLDAP(String serviceId, String account, String xRequestId) throws RestClientException {
        return getAPIKeyViaLDAPWithHttpInfo(serviceId, account, xRequestId).getBody();
    }

    /**
     * Gets the Conjur API key of a user given the LDAP username and password via HTTP Basic Authentication. 
     * Exchange your LDAP credentials for a Conjur API key. Once the API key is obtained, it may be used to inexpensively obtain access tokens by calling the Authenticate method. An access token is required to use most other parts of the Conjur API.  The Basic authentication-compliant header is formed by: 1. Concatenating the LDAP username, a literal colon character &#39;:&#39;,    and the password to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAPIKeyViaLDAPWithHttpInfo(String serviceId, String account, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAPIKeyViaLDAP");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAPIKeyViaLDAP");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn-ldap/{service_id}/{account}/login", uriVariables);

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

        String[] authNames = new String[] { "basicAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token, which is required in the header of most subsequent API requests. 
     * A client can obtain an access token by presenting a valid login name and API key.  The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  This is the default authentication endpoint only. See other endpoints for details on authenticating to Conjur using another method, e.g. for applications running in Azure or Kubernetes. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param body API Key (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessToken(String account, String login, String body, String acceptEncoding, String xRequestId) throws RestClientException {
        return getAccessTokenWithHttpInfo(account, login, body, acceptEncoding, xRequestId).getBody();
    }

    /**
     * Gets a short-lived access token, which is required in the header of most subsequent API requests. 
     * A client can obtain an access token by presenting a valid login name and API key.  The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  This is the default authentication endpoint only. See other endpoints for details on authenticating to Conjur using another method, e.g. for applications running in Azure or Kubernetes. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param body API Key (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenWithHttpInfo(String account, String login, String body, String acceptEncoding, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessToken");
        }
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'login' when calling getAccessToken");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling getAccessToken");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("login", login);
        String path = apiClient.expandPath("/authn/{account}/{login}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "text/plain"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get a short-lived access token for applications running in AWS.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For detailed instructions on authenticating to Conjur using this endpoint, reference the documentation: [AWS IAM Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/AWS_IAM_Authenticator.htm) (&#x60;authn-iam&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param body AWS Signature header (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaAWS(String serviceId, String account, String login, String body, String acceptEncoding, String xRequestId) throws RestClientException {
        return getAccessTokenViaAWSWithHttpInfo(serviceId, account, login, body, acceptEncoding, xRequestId).getBody();
    }

    /**
     * Get a short-lived access token for applications running in AWS.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For detailed instructions on authenticating to Conjur using this endpoint, reference the documentation: [AWS IAM Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/AWS_IAM_Authenticator.htm) (&#x60;authn-iam&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param body AWS Signature header (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaAWSWithHttpInfo(String serviceId, String account, String login, String body, String acceptEncoding, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaAWS");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaAWS");
        }
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'login' when calling getAccessTokenViaAWS");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling getAccessTokenViaAWS");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        uriVariables.put("login", login);
        String path = apiClient.expandPath("/authn-iam/{service_id}/{account}/{login}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "text/plain"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications running in Azure.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Azure Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/azure_authn.htm) (&#x60;authn-azure&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaAzure(String serviceId, String account, String login, String acceptEncoding, String xRequestId, String jwt) throws RestClientException {
        return getAccessTokenViaAzureWithHttpInfo(serviceId, account, login, acceptEncoding, xRequestId, jwt).getBody();
    }

    /**
     * Gets a short-lived access token for applications running in Azure.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Azure Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/azure_authn.htm) (&#x60;authn-azure&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaAzureWithHttpInfo(String serviceId, String account, String login, String acceptEncoding, String xRequestId, String jwt) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaAzure");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaAzure");
        }
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'login' when calling getAccessTokenViaAzure");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        uriVariables.put("login", login);
        String path = apiClient.expandPath("/authn-azure/{service_id}/{account}/{login}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (jwt != null)
            formParams.add("jwt", jwt);

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications running in Google Cloud Platform. 
     * Use the GCP Authenticator API to send an authentication request from a Google Cloud service to Conjur.  For more information, see [the documentation](https://docs.conjur.org/Latest/en/Content/Operations/Services/cjr-gcp-authn.htm). 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaGCP(String account, String acceptEncoding, String xRequestId, String jwt) throws RestClientException {
        return getAccessTokenViaGCPWithHttpInfo(account, acceptEncoding, xRequestId, jwt).getBody();
    }

    /**
     * Gets a short-lived access token for applications running in Google Cloud Platform. 
     * Use the GCP Authenticator API to send an authentication request from a Google Cloud service to Conjur.  For more information, see [the documentation](https://docs.conjur.org/Latest/en/Content/Operations/Services/cjr-gcp-authn.htm). 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaGCPWithHttpInfo(String account, String acceptEncoding, String xRequestId, String jwt) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaGCP");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn-gcp/{account}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (jwt != null)
            formParams.add("jwt", jwt);

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. 
     * Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaJWT(String account, String serviceId, String xRequestId, String jwt) throws RestClientException {
        return getAccessTokenViaJWTWithHttpInfo(account, serviceId, xRequestId, jwt).getBody();
    }

    /**
     * Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. 
     * Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaJWTWithHttpInfo(String account, String serviceId, String xRequestId, String jwt) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaJWT");
        }
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaJWT");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("service_id", serviceId);
        String path = apiClient.expandPath("/authn-jwt/{service_id}/{account}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (jwt != null)
            formParams.add("jwt", jwt);

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. Covers the case of use of optional URL parameter \&quot;ID\&quot; 
     * Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param id Organization user id (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaJWTWithId(String account, String id, String serviceId, String xRequestId, String jwt) throws RestClientException {
        return getAccessTokenViaJWTWithIdWithHttpInfo(account, id, serviceId, xRequestId, jwt).getBody();
    }

    /**
     * Gets a short-lived access token for applications using JSON Web Token (JWT) to access the Conjur API. Covers the case of use of optional URL parameter \&quot;ID\&quot; 
     * Use the JWT Authenticator to leverage the identity layer provided by JWT to authenticate with Conjur. 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param id Organization user id (required)
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param jwt  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaJWTWithIdWithHttpInfo(String account, String id, String serviceId, String xRequestId, String jwt) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaJWTWithId");
        }
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getAccessTokenViaJWTWithId");
        }
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaJWTWithId");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("id", id);
        uriVariables.put("service_id", serviceId);
        String path = apiClient.expandPath("/authn-jwt/{service_id}/{account}/{id}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (jwt != null)
            formParams.add("jwt", jwt);

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications running in Kubernetes.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Kubernetes Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/k8s_auth.htm) (&#x60;authn-k8s&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaKubernetes(String serviceId, String account, String login, String acceptEncoding, String xRequestId) throws RestClientException {
        return getAccessTokenViaKubernetesWithHttpInfo(serviceId, account, login, acceptEncoding, xRequestId).getBody();
    }

    /**
     * Gets a short-lived access token for applications running in Kubernetes.
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded and the host ID must have the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  To authenticate to Conjur using this endpoint, reference the detailed documentation: [Kubernetes Authenticator](https://docs.conjur.org/Latest/en/Content/Operations/Services/k8s_auth.htm) (&#x60;authn-k8s&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaKubernetesWithHttpInfo(String serviceId, String account, String login, String acceptEncoding, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaKubernetes");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaKubernetes");
        }
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'login' when calling getAccessTokenViaKubernetes");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        uriVariables.put("login", login);
        String path = apiClient.expandPath("/authn-k8s/{service_id}/{account}/{login}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurKubernetesMutualTls" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for users and hosts using their LDAP identity to access the Conjur API. 
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  To authenticate to Conjur using a LDAP, reference the detailed documentation: [LDAP Authenticator](https://docs.conjur.org/Latest/en/Content/Integrations/ldap/ldap_authenticator.html) (&#x60;authn-ldap&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param body API key (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaLDAP(String serviceId, String account, String login, String acceptEncoding, String xRequestId, String body) throws RestClientException {
        return getAccessTokenViaLDAPWithHttpInfo(serviceId, account, login, acceptEncoding, xRequestId, body).getBody();
    }

    /**
     * Gets a short-lived access token for users and hosts using their LDAP identity to access the Conjur API. 
     * The access token is used to communicate to the REST API that the bearer of the token has been authorized to access the API and perform specific actions specified by the scope that was granted during authorization.  For API usage, the base64-encoded access token is ordinarily passed as an HTTP Authorization header as &#x60;Authorization: Token token&#x3D;&lt;base64-encoded token&gt;&#x60;.  The &#x60;login&#x60; must be URL encoded. For example, &#x60;alice@devops&#x60; must be encoded as &#x60;alice%40devops&#x60;.  The &#x60;service_id&#x60;, if given, must be URL encoded. For example, &#x60;prod/gke&#x60; must be encoded as &#x60;prod%2Fgke&#x60;.  For host authentication, the &#x60;login&#x60; is the host ID with the prefix &#x60;host/&#x60;. For example, the host webserver would login as &#x60;host/webserver&#x60;, and would be encoded as &#x60;host%2Fwebserver&#x60;.  To authenticate to Conjur using a LDAP, reference the detailed documentation: [LDAP Authenticator](https://docs.conjur.org/Latest/en/Content/Integrations/ldap/ldap_authenticator.html) (&#x60;authn-ldap&#x60;). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param login URL-encoded login name. For users, it’s the user ID. For hosts, the login name is &#x60;host/&lt;host-id&gt;&#x60; (required)
     * @param acceptEncoding Setting the Accept-Encoding header to base64 will return a pre-encoded access token (optional, default to application/json)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param body API key (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaLDAPWithHttpInfo(String serviceId, String account, String login, String acceptEncoding, String xRequestId, String body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaLDAP");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaLDAP");
        }
        
        // verify the required parameter 'login' is set
        if (login == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'login' when calling getAccessTokenViaLDAP");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        uriVariables.put("login", login);
        String path = apiClient.expandPath("/authn-ldap/{service_id}/{account}/{login}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (acceptEncoding != null)
        headerParams.add("Accept-Encoding", apiClient.parameterToString(acceptEncoding));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "text/plain"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Gets a short-lived access token for applications using OpenID Connect (OIDC) to access the Conjur API. 
     * Use the OIDC Authenticator to leverage the identity layer provided by OIDC to authenticate with Conjur.  For more information see [the documentation](https://docs.conjur.org/Latest/en/Content/OIDC/OIDC.htm). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param idToken  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String getAccessTokenViaOIDC(String serviceId, String account, String xRequestId, String idToken) throws RestClientException {
        return getAccessTokenViaOIDCWithHttpInfo(serviceId, account, xRequestId, idToken).getBody();
    }

    /**
     * Gets a short-lived access token for applications using OpenID Connect (OIDC) to access the Conjur API. 
     * Use the OIDC Authenticator to leverage the identity layer provided by OIDC to authenticate with Conjur.  For more information see [the documentation](https://docs.conjur.org/Latest/en/Content/OIDC/OIDC.htm). 
     * <p><b>200</b> - The response is an access token for conjur
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param account Organization account name (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @param idToken  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> getAccessTokenViaOIDCWithHttpInfo(String serviceId, String account, String xRequestId, String idToken) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling getAccessTokenViaOIDC");
        }
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling getAccessTokenViaOIDC");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn-oidc/{service_id}/{account}/authenticate", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        if (idToken != null)
            formParams.add("id_token", idToken);

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/x-www-form-urlencoded"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * For applications running in Kubernetes; sends Conjur a certificate signing request (CSR) and requests a client certificate injected into the application&#39;s Kubernetes pod. 
     * This request sends a Certificate Signing Request to Conjur, which uses the Kubernetes API to inject a client certificate into the application pod.  This endpoint requires a properly configured Conjur Certificate Authority service alongside a properly configured and enabled Kubernetes authenticator. For detailed instructions, see [the documentation](https://docs.conjur.org/Latest/en/Content/Integrations/kubernetes.htm). 
     * <p><b>202</b> - The injected certificate was accepted.
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param body Valid certificate signing request that includes the host identity suffix as the CSR common name  (required)
     * @param hostIdPrefix Dot-separated policy tree, prefixed by &#x60;host.&#x60;, where the application identity is defined (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void k8sInjectClientCert(String serviceId, String body, String hostIdPrefix, String xRequestId) throws RestClientException {
        k8sInjectClientCertWithHttpInfo(serviceId, body, hostIdPrefix, xRequestId);
    }

    /**
     * For applications running in Kubernetes; sends Conjur a certificate signing request (CSR) and requests a client certificate injected into the application&#39;s Kubernetes pod. 
     * This request sends a Certificate Signing Request to Conjur, which uses the Kubernetes API to inject a client certificate into the application pod.  This endpoint requires a properly configured Conjur Certificate Authority service alongside a properly configured and enabled Kubernetes authenticator. For detailed instructions, see [the documentation](https://docs.conjur.org/Latest/en/Content/Integrations/kubernetes.htm). 
     * <p><b>202</b> - The injected certificate was accepted.
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * @param serviceId URL-Encoded authenticator service ID (required)
     * @param body Valid certificate signing request that includes the host identity suffix as the CSR common name  (required)
     * @param hostIdPrefix Dot-separated policy tree, prefixed by &#x60;host.&#x60;, where the application identity is defined (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> k8sInjectClientCertWithHttpInfo(String serviceId, String body, String hostIdPrefix, String xRequestId) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'serviceId' is set
        if (serviceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'serviceId' when calling k8sInjectClientCert");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling k8sInjectClientCert");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("service_id", serviceId);
        String path = apiClient.expandPath("/authn-k8s/{service_id}/inject_client_cert", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        if (hostIdPrefix != null)
        headerParams.add("Host-Id-Prefix", apiClient.parameterToString(hostIdPrefix));
        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "text/plain"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth", "conjurAuth", "conjurKubernetesMutualTls" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Rotates a role&#39;s API key.
     * Any role can rotate its own API key. The name and password (for users) or current API key (for hosts and users) of the role must be provided via HTTP Basic Authorization.  To rotate another role&#39;s API key, you may provide your name and password (for users) or current API key (for hosts and users) via HTTP Basic Authorization with the request. Alternatively, you may provide your Conjur access token via the standard Conjur &#x60;Authorization&#x60; header.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  If using the Conjur &#x60;Authorization&#x60; header, its value should be set to &#x60;Token token&#x3D;&lt;base64-encoded access token&gt;&#x60;.  Note that the body of the request must be the empty string. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param role (**Optional**) role specifier in &#x60;{kind}:{identifier}&#x60; format  ##### Permissions required  &#x60;update&#x60; privilege on the role whose API key is being rotated.  (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return String
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public String rotateApiKey(String account, String role, String xRequestId) throws RestClientException {
        return rotateApiKeyWithHttpInfo(account, role, xRequestId).getBody();
    }

    /**
     * Rotates a role&#39;s API key.
     * Any role can rotate its own API key. The name and password (for users) or current API key (for hosts and users) of the role must be provided via HTTP Basic Authorization.  To rotate another role&#39;s API key, you may provide your name and password (for users) or current API key (for hosts and users) via HTTP Basic Authorization with the request. Alternatively, you may provide your Conjur access token via the standard Conjur &#x60;Authorization&#x60; header.  The Basic authentication-compliant header is formed by: 1. Concatenating the role&#39;s name, a literal colon character &#39;:&#39;,    and the password or API key to create the authentication string. 2. Base64-encoding the authentication string. 3. Prefixing the authentication string with the scheme: &#x60;Basic &#x60;    (note the required space). 4. Providing the result as the value of the &#x60;Authorization&#x60; HTTP header:    &#x60;Authorization: Basic &lt;authentication string&gt;&#x60;.  Your HTTP/REST client probably provides HTTP basic authentication support. For example, &#x60;curl&#x60; and all of the Conjur client libraries provide this.  If using the Conjur &#x60;Authorization&#x60; header, its value should be set to &#x60;Token token&#x3D;&lt;base64-encoded access token&gt;&#x60;.  Note that the body of the request must be the empty string. 
     * <p><b>200</b> - The response body is the API key
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * <p><b>500</b> - Malfromed request, rejected by the server
     * @param account Organization account name (required)
     * @param role (**Optional**) role specifier in &#x60;{kind}:{identifier}&#x60; format  ##### Permissions required  &#x60;update&#x60; privilege on the role whose API key is being rotated.  (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;String&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<String> rotateApiKeyWithHttpInfo(String account, String role, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling rotateApiKey");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/authn/{account}/api_key", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "text/plain"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "basicAuth", "conjurAuth" };

        ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
