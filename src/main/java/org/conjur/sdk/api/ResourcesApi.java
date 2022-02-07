package org.conjur.sdk.api;

import org.conjur.sdk.ApiClient;

import org.conjur.sdk.model.Resource;

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
@Component("org.conjur.sdk.api.ResourcesApi")
public class ResourcesApi {
    private ApiClient apiClient;

    public ResourcesApi() {
        this(new ApiClient());
    }

    @Autowired
    public ResourcesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Shows a description of a single resource.
     * Details about a single resource.  If &#x60;permitted_roles&#x60; and &#x60;privilege&#x60; are given, Conjur lists the roles with the specified privilege on the resource.  If &#x60;check&#x60;, &#x60;privilege&#x60; and &#x60;role&#x60; are given, Conjur checks if the specified role has the privilege on the resource.  If &#x60;permitted_roles&#x60; and &#x60;check&#x60; are both given, Conjur responds to the &#x60;check&#x60; call ONLY.  ##### Permissions Required 
     * <p><b>200</b> - The response body contains the list of role memberships or permitted roles
     * <p><b>204</b> - Permissions check was successful
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the resource for which to get the information about (required)
     * @param permittedRoles Lists the roles which have the named privilege on a resource. (optional)
     * @param privilege Level of privilege to filter on. Can only be used in combination with &#x60;permitted_roles&#x60; or &#x60;check&#x60; parameter. (optional)
     * @param check Check whether a role has a privilege on a resource. (optional)
     * @param role Role to check privilege on. Can only be used in combination with &#x60;check&#x60; parameter. (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return Resource
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Resource showResource(String account, String kind, String identifier, Boolean permittedRoles, String privilege, Boolean check, String role, String xRequestId) throws RestClientException {
        return showResourceWithHttpInfo(account, kind, identifier, permittedRoles, privilege, check, role, xRequestId).getBody();
    }

    /**
     * Shows a description of a single resource.
     * Details about a single resource.  If &#x60;permitted_roles&#x60; and &#x60;privilege&#x60; are given, Conjur lists the roles with the specified privilege on the resource.  If &#x60;check&#x60;, &#x60;privilege&#x60; and &#x60;role&#x60; are given, Conjur checks if the specified role has the privilege on the resource.  If &#x60;permitted_roles&#x60; and &#x60;check&#x60; are both given, Conjur responds to the &#x60;check&#x60; call ONLY.  ##### Permissions Required 
     * <p><b>200</b> - The response body contains the list of role memberships or permitted roles
     * <p><b>204</b> - Permissions check was successful
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the resource for which to get the information about (required)
     * @param permittedRoles Lists the roles which have the named privilege on a resource. (optional)
     * @param privilege Level of privilege to filter on. Can only be used in combination with &#x60;permitted_roles&#x60; or &#x60;check&#x60; parameter. (optional)
     * @param check Check whether a role has a privilege on a resource. (optional)
     * @param role Role to check privilege on. Can only be used in combination with &#x60;check&#x60; parameter. (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Resource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Resource> showResourceWithHttpInfo(String account, String kind, String identifier, Boolean permittedRoles, String privilege, Boolean check, String role, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling showResource");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling showResource");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling showResource");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/resources/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "permitted_roles", permittedRoles));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "privilege", privilege));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "check", check));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Resource> returnType = new ParameterizedTypeReference<Resource>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Lists resources within an organization account.
     * Lists resources within an organization account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (optional)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return List&lt;Resource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Resource> showResourcesForAccount(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        return showResourcesForAccountWithHttpInfo(account, kind, search, offset, limit, count, role, actingAs, xRequestId).getBody();
    }

    /**
     * Lists resources within an organization account.
     * Lists resources within an organization account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (optional)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;List&lt;Resource&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Resource>> showResourcesForAccountWithHttpInfo(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling showResourcesForAccount");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        String path = apiClient.expandPath("/resources/{account}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "kind", kind));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "search", search));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "acting_as", actingAs));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<List<Resource>> returnType = new ParameterizedTypeReference<List<Resource>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Lists resources within an organization account.
     * Lists resources within an organization account.  In the absence of an &#x60;account&#x60; query parameter, shows results for the account of the authorization token user.  If an &#x60;account&#x60; query parameter is given, shows results for the specified account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;.\&quot; 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (optional)
     * @param kind Type of resource (optional)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return List&lt;Resource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Resource> showResourcesForAllAccounts(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        return showResourcesForAllAccountsWithHttpInfo(account, kind, search, offset, limit, count, role, actingAs, xRequestId).getBody();
    }

    /**
     * Lists resources within an organization account.
     * Lists resources within an organization account.  In the absence of an &#x60;account&#x60; query parameter, shows results for the account of the authorization token user.  If an &#x60;account&#x60; query parameter is given, shows results for the specified account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;.\&quot; 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (optional)
     * @param kind Type of resource (optional)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;List&lt;Resource&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Resource>> showResourcesForAllAccountsWithHttpInfo(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        String path = apiClient.expandPath("/resources", Collections.<String, Object>emptyMap());

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "account", account));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "kind", kind));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "search", search));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "acting_as", actingAs));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<List<Resource>> returnType = new ParameterizedTypeReference<List<Resource>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Lists resources of the same kind within an organization account.
     * Lists resources of the same kind within an organization account.  Kinds of resources include: policy, user, host, group, layer, or variable  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return List&lt;Resource&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Resource> showResourcesForKind(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        return showResourcesForKindWithHttpInfo(account, kind, search, offset, limit, count, role, actingAs, xRequestId).getBody();
    }

    /**
     * Lists resources of the same kind within an organization account.
     * Lists resources of the same kind within an organization account.  Kinds of resources include: policy, user, host, group, layer, or variable  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     * <p><b>200</b> - The response body contains a list of resources
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param search Filter resources based on this value by name (optional)
     * @param offset When listing resources, start at this item number. (optional)
     * @param limit When listing resources, return up to this many results. (optional)
     * @param count When listing resources, if &#x60;true&#x60;, return only the count of the results. (optional)
     * @param role Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param actingAs Retrieves the resources list for a different role if the authenticated role has access (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;List&lt;Resource&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<Resource>> showResourcesForKindWithHttpInfo(String account, String kind, String search, Integer offset, Integer limit, Boolean count, String role, String actingAs, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling showResourcesForKind");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling showResourcesForKind");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        String path = apiClient.expandPath("/resources/{account}/{kind}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "search", search));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "role", role));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "acting_as", actingAs));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<List<Resource>> returnType = new ParameterizedTypeReference<List<Resource>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
}
