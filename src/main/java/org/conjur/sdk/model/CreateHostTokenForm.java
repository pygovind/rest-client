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
 * CreateHostTokenForm
 */
@JsonPropertyOrder({
  CreateHostTokenForm.JSON_PROPERTY_CIDR,
  CreateHostTokenForm.JSON_PROPERTY_COUNT,
  CreateHostTokenForm.JSON_PROPERTY_EXPIRATION,
  CreateHostTokenForm.JSON_PROPERTY_HOST_FACTORY
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-02-05T02:00:27.403Z[GMT]")
public class CreateHostTokenForm {
  public static final String JSON_PROPERTY_CIDR = "cidr";
  private List<String> cidr = null;

  public static final String JSON_PROPERTY_COUNT = "count";
  private Integer count;

  public static final String JSON_PROPERTY_EXPIRATION = "expiration";
  private String expiration;

  public static final String JSON_PROPERTY_HOST_FACTORY = "host_factory";
  private String hostFactory;


  public CreateHostTokenForm cidr(List<String> cidr) {
    
    this.cidr = cidr;
    return this;
  }

  public CreateHostTokenForm addCidrItem(String cidrItem) {
    if (this.cidr == null) {
      this.cidr = new ArrayList<String>();
    }
    this.cidr.add(cidrItem);
    return this;
  }

   /**
   * Number of host tokens to create
   * @return cidr
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "[\"127.0.0.1/32\"]", value = "Number of host tokens to create")
  @JsonProperty(JSON_PROPERTY_CIDR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getCidr() {
    return cidr;
  }


  public void setCidr(List<String> cidr) {
    this.cidr = cidr;
  }


  public CreateHostTokenForm count(Integer count) {
    
    this.count = count;
    return this;
  }

   /**
   * Number of host tokens to create
   * @return count
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(example = "2", value = "Number of host tokens to create")
  @JsonProperty(JSON_PROPERTY_COUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Integer getCount() {
    return count;
  }


  public void setCount(Integer count) {
    this.count = count;
  }


  public CreateHostTokenForm expiration(String expiration) {
    
    this.expiration = expiration;
    return this;
  }

   /**
   * &#x60;ISO 8601 datetime&#x60; denoting a requested expiration time.
   * @return expiration
  **/
  @ApiModelProperty(example = "2017-08-04T22:27:20+00:00", required = true, value = "`ISO 8601 datetime` denoting a requested expiration time.")
  @JsonProperty(JSON_PROPERTY_EXPIRATION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getExpiration() {
    return expiration;
  }


  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }


  public CreateHostTokenForm hostFactory(String hostFactory) {
    
    this.hostFactory = hostFactory;
    return this;
  }

   /**
   * Fully qualified host factory ID
   * @return hostFactory
  **/
  @ApiModelProperty(example = "myorg:host_factory:hf-db", required = true, value = "Fully qualified host factory ID")
  @JsonProperty(JSON_PROPERTY_HOST_FACTORY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHostFactory() {
    return hostFactory;
  }


  public void setHostFactory(String hostFactory) {
    this.hostFactory = hostFactory;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateHostTokenForm createHostTokenForm = (CreateHostTokenForm) o;
    return Objects.equals(this.cidr, createHostTokenForm.cidr) &&
        Objects.equals(this.count, createHostTokenForm.count) &&
        Objects.equals(this.expiration, createHostTokenForm.expiration) &&
        Objects.equals(this.hostFactory, createHostTokenForm.hostFactory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cidr, count, expiration, hostFactory);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateHostTokenForm {\n");
    sb.append("    cidr: ").append(toIndentedString(cidr)).append("\n");
    sb.append("    count: ").append(toIndentedString(count)).append("\n");
    sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    sb.append("    hostFactory: ").append(toIndentedString(hostFactory)).append("\n");
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

