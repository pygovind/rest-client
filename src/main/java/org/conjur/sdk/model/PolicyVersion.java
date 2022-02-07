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
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * PolicyVersion
 */
@JsonPropertyOrder({
  PolicyVersion.JSON_PROPERTY_CLIENT_IP,
  PolicyVersion.JSON_PROPERTY_CREATED_AT,
  PolicyVersion.JSON_PROPERTY_FINISHED_AT,
  PolicyVersion.JSON_PROPERTY_ID,
  PolicyVersion.JSON_PROPERTY_POLICY_SHA256,
  PolicyVersion.JSON_PROPERTY_POLICY_TEXT,
  PolicyVersion.JSON_PROPERTY_ROLE,
  PolicyVersion.JSON_PROPERTY_VERSION
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
public class PolicyVersion {
  public static final String JSON_PROPERTY_CLIENT_IP = "client_ip";
  private String clientIp;

  public static final String JSON_PROPERTY_CREATED_AT = "created_at";
  private String createdAt;

  public static final String JSON_PROPERTY_FINISHED_AT = "finished_at";
  private String finishedAt;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_POLICY_SHA256 = "policy_sha256";
  private String policySha256;

  public static final String JSON_PROPERTY_POLICY_TEXT = "policy_text";
  private String policyText;

  public static final String JSON_PROPERTY_ROLE = "role";
  private String role;

  public static final String JSON_PROPERTY_VERSION = "version";
  private BigDecimal version;


  public PolicyVersion clientIp(String clientIp) {
    
    this.clientIp = clientIp;
    return this;
  }

   /**
   * Get clientIp
   * @return clientIp
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_CLIENT_IP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getClientIp() {
    return clientIp;
  }


  public void setClientIp(String clientIp) {
    this.clientIp = clientIp;
  }


  public PolicyVersion createdAt(String createdAt) {
    
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


  public PolicyVersion finishedAt(String finishedAt) {
    
    this.finishedAt = finishedAt;
    return this;
  }

   /**
   * Get finishedAt
   * @return finishedAt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_FINISHED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getFinishedAt() {
    return finishedAt;
  }


  public void setFinishedAt(String finishedAt) {
    this.finishedAt = finishedAt;
  }


  public PolicyVersion id(String id) {
    
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


  public PolicyVersion policySha256(String policySha256) {
    
    this.policySha256 = policySha256;
    return this;
  }

   /**
   * Get policySha256
   * @return policySha256
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POLICY_SHA256)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPolicySha256() {
    return policySha256;
  }


  public void setPolicySha256(String policySha256) {
    this.policySha256 = policySha256;
  }


  public PolicyVersion policyText(String policyText) {
    
    this.policyText = policyText;
    return this;
  }

   /**
   * Get policyText
   * @return policyText
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_POLICY_TEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getPolicyText() {
    return policyText;
  }


  public void setPolicyText(String policyText) {
    this.policyText = policyText;
  }


  public PolicyVersion role(String role) {
    
    this.role = role;
    return this;
  }

   /**
   * Get role
   * @return role
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_ROLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRole() {
    return role;
  }


  public void setRole(String role) {
    this.role = role;
  }


  public PolicyVersion version(BigDecimal version) {
    
    this.version = version;
    return this;
  }

   /**
   * Get version
   * @return version
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getVersion() {
    return version;
  }


  public void setVersion(BigDecimal version) {
    this.version = version;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PolicyVersion policyVersion = (PolicyVersion) o;
    return Objects.equals(this.clientIp, policyVersion.clientIp) &&
        Objects.equals(this.createdAt, policyVersion.createdAt) &&
        Objects.equals(this.finishedAt, policyVersion.finishedAt) &&
        Objects.equals(this.id, policyVersion.id) &&
        Objects.equals(this.policySha256, policyVersion.policySha256) &&
        Objects.equals(this.policyText, policyVersion.policyText) &&
        Objects.equals(this.role, policyVersion.role) &&
        Objects.equals(this.version, policyVersion.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientIp, createdAt, finishedAt, id, policySha256, policyText, role, version);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PolicyVersion {\n");
    sb.append("    clientIp: ").append(toIndentedString(clientIp)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    finishedAt: ").append(toIndentedString(finishedAt)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    policySha256: ").append(toIndentedString(policySha256)).append("\n");
    sb.append("    policyText: ").append(toIndentedString(policyText)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
