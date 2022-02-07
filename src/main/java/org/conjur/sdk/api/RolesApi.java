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
@Component("org.conjur.sdk.api.RolesApi")
public class RolesApi {
    private ApiClient apiClient;

    public RolesApi() {
        this(new ApiClient());
    }

    @Autowired
    public RolesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Update or modify an existing role membership
     * Updates or modifies an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be added as a member of the role specified in the endpoint URI. 
     * <p><b>204</b> - Member was added to role successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param members Returns a list of the Role&#39;s members. (required)
     * @param member The identifier of the Role to be added as a member. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addMemberToRole(String account, String kind, String identifier, String members, String member, String xRequestId) throws RestClientException {
        addMemberToRoleWithHttpInfo(account, kind, identifier, members, member, xRequestId);
    }

    /**
     * Update or modify an existing role membership
     * Updates or modifies an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be added as a member of the role specified in the endpoint URI. 
     * <p><b>204</b> - Member was added to role successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param members Returns a list of the Role&#39;s members. (required)
     * @param member The identifier of the Role to be added as a member. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> addMemberToRoleWithHttpInfo(String account, String kind, String identifier, String members, String member, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling addMemberToRole");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling addMemberToRole");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling addMemberToRole");
        }
        
        // verify the required parameter 'members' is set
        if (members == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'members' when calling addMemberToRole");
        }
        
        // verify the required parameter 'member' is set
        if (member == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'member' when calling addMemberToRole");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/roles/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "members", members));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "member", member));

        if (xRequestId != null)
        headerParams.add("X-Request-Id", apiClient.parameterToString(xRequestId));

        final String[] accepts = { };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "conjurAuth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, cookieParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Deletes an existing role membership
     * Deletes an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be removed as a member of the role specified in the endpoint URI. 
     * <p><b>204</b> - Member was deleted from role successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param members Returns a list of the Role&#39;s members. (required)
     * @param member The identifier of the Role to be added as a member. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void removeMemberFromRole(String account, String kind, String identifier, String members, String member, String xRequestId) throws RestClientException {
        removeMemberFromRoleWithHttpInfo(account, kind, identifier, members, member, xRequestId);
    }

    /**
     * Deletes an existing role membership
     * Deletes an existing role membership.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  When the &#x60;members&#x60; query parameter is provided, you will get the members of a role.  When the &#x60;members&#x60; and &#x60;member&#x60; query parameters are provided, the role specfified by &#x60;member&#x60; will be removed as a member of the role specified in the endpoint URI. 
     * <p><b>204</b> - Member was deleted from role successfully
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param members Returns a list of the Role&#39;s members. (required)
     * @param member The identifier of the Role to be added as a member. (required)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> removeMemberFromRoleWithHttpInfo(String account, String kind, String identifier, String members, String member, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling removeMemberFromRole");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling removeMemberFromRole");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling removeMemberFromRole");
        }
        
        // verify the required parameter 'members' is set
        if (members == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'members' when calling removeMemberFromRole");
        }
        
        // verify the required parameter 'member' is set
        if (member == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'member' when calling removeMemberFromRole");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/roles/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "members", members));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "member", member));

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
    /**
     * Get role information
     * Gets detailed information about a specific role, including the role members.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  ##### Listing members  If &#x60;members&#x60; is provided, you will get the members of a role.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give limit a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is true, returns only the number of items in the list.  ##### Text search  If the search parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weights results so that those with matching id or a matching value of an annotation called name appear first, then those with another matching annotation value, and finally those with a matching kind.  ##### Parameter Priority  If Conjur is given any combination of optional parameters, it responds with ONLY results for the parameter of the highest priority.  1. &#x60;graph&#x60; 2. &#x60;all&#x60; 3. &#x60;memberships&#x60; 4. &#x60;members&#x60; 
     * <p><b>200</b> - The response body contains the requested role(s)/member(s)
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param all Returns an array of Role IDs representing all role memberships, expanded recursively. (optional)
     * @param memberships Returns all direct role memberships (members not expanded recursively). (optional)
     * @param members Returns a list of the Role&#39;s members. (optional)
     * @param offset When listing members, start at this item number. (optional)
     * @param limit When listing members, return up to this many results. (optional)
     * @param count When listing members, if &#x60;true&#x60;, return only the count of members. (optional)
     * @param search When listing members, the results will be narrowed to only those matching the provided string (optional)
     * @param graph If included in the query returns a graph view of the role (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object showRole(String account, String kind, String identifier, String all, String memberships, String members, Integer offset, Integer limit, Boolean count, String search, String graph, String xRequestId) throws RestClientException {
        return showRoleWithHttpInfo(account, kind, identifier, all, memberships, members, offset, limit, count, search, graph, xRequestId).getBody();
    }

    /**
     * Get role information
     * Gets detailed information about a specific role, including the role members.  If a role A is granted to a role B, then role A is said to have role B as a member. These relationships are described in the “members” portion of the returned JSON.  ##### Listing members  If &#x60;members&#x60; is provided, you will get the members of a role.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give limit a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is true, returns only the number of items in the list.  ##### Text search  If the search parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weights results so that those with matching id or a matching value of an annotation called name appear first, then those with another matching annotation value, and finally those with a matching kind.  ##### Parameter Priority  If Conjur is given any combination of optional parameters, it responds with ONLY results for the parameter of the highest priority.  1. &#x60;graph&#x60; 2. &#x60;all&#x60; 3. &#x60;memberships&#x60; 4. &#x60;members&#x60; 
     * <p><b>200</b> - The response body contains the requested role(s)/member(s)
     * <p><b>400</b> - The server cannot process the request due to malformed request syntax
     * <p><b>401</b> - Authentication information is missing or invalid
     * <p><b>403</b> - The authenticated user lacks the necessary privileges
     * <p><b>404</b> - The requested resource does not exist, the authenticated user lacks the required privileges to enumerate this resource, or its value has not been set
     * <p><b>422</b> - A request parameter was either missing or invalid.
     * @param account Organization account name (required)
     * @param kind Type of resource (required)
     * @param identifier ID of the role for which to get the information about (required)
     * @param all Returns an array of Role IDs representing all role memberships, expanded recursively. (optional)
     * @param memberships Returns all direct role memberships (members not expanded recursively). (optional)
     * @param members Returns a list of the Role&#39;s members. (optional)
     * @param offset When listing members, start at this item number. (optional)
     * @param limit When listing members, return up to this many results. (optional)
     * @param count When listing members, if &#x60;true&#x60;, return only the count of members. (optional)
     * @param search When listing members, the results will be narrowed to only those matching the provided string (optional)
     * @param graph If included in the query returns a graph view of the role (optional)
     * @param xRequestId Add an ID to the request being made so it can be tracked in Conjur. If not provided the server will automatically generate one.  (optional)
     * @return ResponseEntity&lt;Object&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Object> showRoleWithHttpInfo(String account, String kind, String identifier, String all, String memberships, String members, Integer offset, Integer limit, Boolean count, String search, String graph, String xRequestId) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'account' is set
        if (account == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'account' when calling showRole");
        }
        
        // verify the required parameter 'kind' is set
        if (kind == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'kind' when calling showRole");
        }
        
        // verify the required parameter 'identifier' is set
        if (identifier == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'identifier' when calling showRole");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("account", account);
        uriVariables.put("kind", kind);
        uriVariables.put("identifier", identifier);
        String path = apiClient.expandPath("/roles/{account}/{kind}/{identifier}", uriVariables);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap formParams = new LinkedMultiValueMap();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all", all));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "memberships", memberships));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "members", members));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "offset", offset));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "limit", limit));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "count", count));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "search", search));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "graph", graph));

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
