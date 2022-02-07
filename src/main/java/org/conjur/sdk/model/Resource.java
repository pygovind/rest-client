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


package org.conjur.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.conjur.sdk.model.PolicyVersion;
import org.conjur.sdk.model.ResourcePermissions;
import org.conjur.sdk.model.ResourceSecrets;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Resource
 */
@JsonPropertyOrder({
  Resource.JSON_PROPERTY_ANNOTATIONS,
  Resource.JSON_PROPERTY_CREATED_AT,
  Resource.JSON_PROPERTY_ID,
  Resource.JSON_PROPERTY_OWNER,
  Resource.JSON_PROPERTY_PERMISSIONS,
  Resource.JSON_PROPERTY_POLICY,
  Resource.JSON_PROPERTY_POLICY_VERSIONS,
  Resource.JSON_PROPERTY_RESTRICTED_TO,
  Resource.JSON_PROPERTY_SECRETS
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
public class Resource {
  public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
  private List<String> annotations = null;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private String createdAt;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_OWNER = "owner";
  private String owner;

  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  private List<ResourcePermissions> permissions = null;

  public static final String JSON_PROPERTY_POLICY = "policy";
  private String policy;

  public static final String JSON_PROPERTY_POLICY_VERSIONS = "policy_versions";
  private List<PolicyVersion> policyVersions = null;

  public static final String JSON_PROPERTY_RESTRICTED_TO = "restricted_to";
  private List<String> restrictedTo = null;

  public static final String JSON_PROPERTY_SECRETS = "secrets";
  private List<ResourceSecrets> secrets = null;


  public Resource annotations(List<String> annotations) {
    
    this.annotations = annotations;
    return this;
  }

  public Resource addAnnotationsItem(String annotationsItem) {
    if (this.annotations == null) {
      this.annotations = new ArrayList<String>();
    }
    this.annotations.add(annotationsItem);
    return this;
  }

   /**
   * Get annotations
   * @return annotations
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ANNOTATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getAnnotations() {
    return annotations;
  }


  public void setAnnotations(List<String> annotations) {
    this.annotations = annotations;
  }


  public Resource createdAt(String createdAt) {
    
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Get createdAt
   * @return createdAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCreatedAt() {
    return createdAt;
  }


  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }


  public Resource id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public Resource owner(String owner) {
    
    this.owner = owner;
    return this;
  }

   /**
   * Get owner
   * @return owner
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_OWNER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOwner() {
    return owner;
  }


  public void setOwner(String owner) {
    this.owner = owner;
  }


  public Resource permissions(List<ResourcePermissions> permissions) {
    
    this.permissions = permissions;
    return this;
  }

  public Resource addPermissionsItem(ResourcePermissions permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<ResourcePermissions>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_PERMISSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ResourcePermissions> getPermissions() {
    return permissions;
  }


  public void setPermissions(List<ResourcePermissions> permissions) {
    this.permissions = permissions;
  }


  public Resource policy(String policy) {
    
    this.policy = policy;
    return this;
  }

   /**
   * Get policy
   * @return policy
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POLICY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPolicy() {
    return policy;
  }


  public void setPolicy(String policy) {
    this.policy = policy;
  }


  public Resource policyVersions(List<PolicyVersion> policyVersions) {
    
    this.policyVersions = policyVersions;
    return this;
  }

  public Resource addPolicyVersionsItem(PolicyVersion policyVersionsItem) {
    if (this.policyVersions == null) {
      this.policyVersions = new ArrayList<PolicyVersion>();
    }
    this.policyVersions.add(policyVersionsItem);
    return this;
  }

   /**
   * Get policyVersions
   * @return policyVersions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POLICY_VERSIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<PolicyVersion> getPolicyVersions() {
    return policyVersions;
  }


  public void setPolicyVersions(List<PolicyVersion> policyVersions) {
    this.policyVersions = policyVersions;
  }


  public Resource restrictedTo(List<String> restrictedTo) {
    
    this.restrictedTo = restrictedTo;
    return this;
  }

  public Resource addRestrictedToItem(String restrictedToItem) {
    if (this.restrictedTo == null) {
      this.restrictedTo = new ArrayList<String>();
    }
    this.restrictedTo.add(restrictedToItem);
    return this;
  }

   /**
   * Get restrictedTo
   * @return restrictedTo
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_RESTRICTED_TO)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getRestrictedTo() {
    return restrictedTo;
  }


  public void setRestrictedTo(List<String> restrictedTo) {
    this.restrictedTo = restrictedTo;
  }


  public Resource secrets(List<ResourceSecrets> secrets) {
    
    this.secrets = secrets;
    return this;
  }

  public Resource addSecretsItem(ResourceSecrets secretsItem) {
    if (this.secrets == null) {
      this.secrets = new ArrayList<ResourceSecrets>();
    }
    this.secrets.add(secretsItem);
    return this;
  }

   /**
   * Get secrets
   * @return secrets
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SECRETS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<ResourceSecrets> getSecrets() {
    return secrets;
  }


  public void setSecrets(List<ResourceSecrets> secrets) {
    this.secrets = secrets;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Resource resource = (Resource) o;
    return Objects.equals(this.annotations, resource.annotations) &&
        Objects.equals(this.createdAt, resource.createdAt) &&
        Objects.equals(this.id, resource.id) &&
        Objects.equals(this.owner, resource.owner) &&
        Objects.equals(this.permissions, resource.permissions) &&
        Objects.equals(this.policy, resource.policy) &&
        Objects.equals(this.policyVersions, resource.policyVersions) &&
        Objects.equals(this.restrictedTo, resource.restrictedTo) &&
        Objects.equals(this.secrets, resource.secrets);
  }

  @Override
  public int hashCode() {
    return Objects.hash(annotations, createdAt, id, owner, permissions, policy, policyVersions, restrictedTo, secrets);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Resource {\n");
    sb.append("    annotations: ").append(toIndentedString(annotations)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    policy: ").append(toIndentedString(policy)).append("\n");
    sb.append("    policyVersions: ").append(toIndentedString(policyVersions)).append("\n");
    sb.append("    restrictedTo: ").append(toIndentedString(restrictedTo)).append("\n");
    sb.append("    secrets: ").append(toIndentedString(secrets)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
