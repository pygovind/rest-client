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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Azure instance identity token
 */
@ApiModel(description = "Azure instance identity token")
@JsonPropertyOrder({
  AzureIdentityToken.JSON_PROPERTY_JWT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
public class AzureIdentityToken {
  public static final String JSON_PROPERTY_JWT = "jwt";
  private String jwt;


  public AzureIdentityToken jwt(String jwt) {
    
    this.jwt = jwt;
    return this;
  }

   /**
   * Get jwt
   * @return jwt
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_JWT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getJwt() {
    return jwt;
  }


  public void setJwt(String jwt) {
    this.jwt = jwt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AzureIdentityToken azureIdentityToken = (AzureIdentityToken) o;
    return Objects.equals(this.jwt, azureIdentityToken.jwt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jwt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AzureIdentityToken {\n");
    sb.append("    jwt: ").append(toIndentedString(jwt)).append("\n");
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

