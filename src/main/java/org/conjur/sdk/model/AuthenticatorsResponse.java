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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * AuthenticatorsResponse
 */
@JsonPropertyOrder({
  AuthenticatorsResponse.JSON_PROPERTY_CONFIGURED,
  AuthenticatorsResponse.JSON_PROPERTY_ENABLED,
  AuthenticatorsResponse.JSON_PROPERTY_INSTALLED
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
public class AuthenticatorsResponse {
  public static final String JSON_PROPERTY_CONFIGURED = "configured";
  private List<String> configured = null;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  private List<String> enabled = null;

  public static final String JSON_PROPERTY_INSTALLED = "installed";
  private List<String> installed = null;


  public AuthenticatorsResponse configured(List<String> configured) {
    
    this.configured = configured;
    return this;
  }

  public AuthenticatorsResponse addConfiguredItem(String configuredItem) {
    if (this.configured == null) {
      this.configured = new ArrayList<String>();
    }
    this.configured.add(configuredItem);
    return this;
  }

   /**
   * The authenticators configured on the Conjur server
   * @return configured
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[\"authn\"]", value = "The authenticators configured on the Conjur server")
  @JsonProperty(JSON_PROPERTY_CONFIGURED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getConfigured() {
    return configured;
  }


  public void setConfigured(List<String> configured) {
    this.configured = configured;
  }


  public AuthenticatorsResponse enabled(List<String> enabled) {
    
    this.enabled = enabled;
    return this;
  }

  public AuthenticatorsResponse addEnabledItem(String enabledItem) {
    if (this.enabled == null) {
      this.enabled = new ArrayList<String>();
    }
    this.enabled.add(enabledItem);
    return this;
  }

   /**
   * The authenticators enabled on the Conjur server
   * @return enabled
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[\"authn\"]", value = "The authenticators enabled on the Conjur server")
  @JsonProperty(JSON_PROPERTY_ENABLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getEnabled() {
    return enabled;
  }


  public void setEnabled(List<String> enabled) {
    this.enabled = enabled;
  }


  public AuthenticatorsResponse installed(List<String> installed) {
    
    this.installed = installed;
    return this;
  }

  public AuthenticatorsResponse addInstalledItem(String installedItem) {
    if (this.installed == null) {
      this.installed = new ArrayList<String>();
    }
    this.installed.add(installedItem);
    return this;
  }

   /**
   * The authenticators installed on the Conjur server
   * @return installed
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[\"authn\"]", value = "The authenticators installed on the Conjur server")
  @JsonProperty(JSON_PROPERTY_INSTALLED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getInstalled() {
    return installed;
  }


  public void setInstalled(List<String> installed) {
    this.installed = installed;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticatorsResponse authenticatorsResponse = (AuthenticatorsResponse) o;
    return Objects.equals(this.configured, authenticatorsResponse.configured) &&
        Objects.equals(this.enabled, authenticatorsResponse.enabled) &&
        Objects.equals(this.installed, authenticatorsResponse.installed);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configured, enabled, installed);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticatorsResponse {\n");
    sb.append("    configured: ").append(toIndentedString(configured)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
    sb.append("    installed: ").append(toIndentedString(installed)).append("\n");
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

