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

import org.conjur.sdk.model.Resource;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ResourcesApi
 */
@Ignore
public class ResourcesApiTest {

    private final ResourcesApi api = new ResourcesApi();

    
    /**
     * Shows a description of a single resource.
     *
     * Details about a single resource.  If &#x60;permitted_roles&#x60; and &#x60;privilege&#x60; are given, Conjur lists the roles with the specified privilege on the resource.  If &#x60;check&#x60;, &#x60;privilege&#x60; and &#x60;role&#x60; are given, Conjur checks if the specified role has the privilege on the resource.  If &#x60;permitted_roles&#x60; and &#x60;check&#x60; are both given, Conjur responds to the &#x60;check&#x60; call ONLY.  ##### Permissions Required 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void showResourceTest() {
        String account = null;
        String kind = null;
        String identifier = null;
        Boolean permittedRoles = null;
        String privilege = null;
        Boolean check = null;
        String role = null;
        String xRequestId = null;
        Resource response = api.showResource(account, kind, identifier, permittedRoles, privilege, check, role, xRequestId);

        // TODO: test validations
    }
    
    /**
     * Lists resources within an organization account.
     *
     * Lists resources within an organization account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void showResourcesForAccountTest() {
        String account = null;
        String kind = null;
        String search = null;
        Integer offset = null;
        Integer limit = null;
        Boolean count = null;
        String role = null;
        String actingAs = null;
        String xRequestId = null;
        List<Resource> response = api.showResourcesForAccount(account, kind, search, offset, limit, count, role, actingAs, xRequestId);

        // TODO: test validations
    }
    
    /**
     * Lists resources within an organization account.
     *
     * Lists resources within an organization account.  In the absence of an &#x60;account&#x60; query parameter, shows results for the account of the authorization token user.  If an &#x60;account&#x60; query parameter is given, shows results for the specified account.  If a &#x60;kind&#x60; query parameter is given, narrows results to only resources of that kind.  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;.\&quot; 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void showResourcesForAllAccountsTest() {
        String account = null;
        String kind = null;
        String search = null;
        Integer offset = null;
        Integer limit = null;
        Boolean count = null;
        String role = null;
        String actingAs = null;
        String xRequestId = null;
        List<Resource> response = api.showResourcesForAllAccounts(account, kind, search, offset, limit, count, role, actingAs, xRequestId);

        // TODO: test validations
    }
    
    /**
     * Lists resources of the same kind within an organization account.
     *
     * Lists resources of the same kind within an organization account.  Kinds of resources include: policy, user, host, group, layer, or variable  If a &#x60;limit&#x60; is given, returns no more than that number of results. Providing an &#x60;offset&#x60; skips a number of resources before returning the rest. In addition, providing an &#x60;offset&#x60; will give &#x60;limit&#x60; a default value of 10 if none other is provided. These two parameters can be combined to page through results.  If the parameter &#x60;count&#x60; is &#x60;true&#x60;, returns only the number of items in the list.  ##### Text search  If the &#x60;search&#x60; parameter is provided, narrows results to those pertaining to the search query. Search works across resource IDs and the values of annotations. It weighs results so that those with matching id or a matching value of an annotation called &#x60;name&#x60; appear first, then those with another matching annotation value, and finally those with a matching  &#x60;kind&#x60;. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void showResourcesForKindTest() {
        String account = null;
        String kind = null;
        String search = null;
        Integer offset = null;
        Integer limit = null;
        Boolean count = null;
        String role = null;
        String actingAs = null;
        String xRequestId = null;
        List<Resource> response = api.showResourcesForKind(account, kind, search, offset, limit, count, role, actingAs, xRequestId);

        // TODO: test validations
    }
    
}
