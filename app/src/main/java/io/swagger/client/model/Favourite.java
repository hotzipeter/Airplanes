/**
 * FavouriteList API
 * Get, delete, update favourite airlines
 *
 * OpenAPI spec version: 1.0.0
 * Contact: hotzipeti@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.model;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;

@ApiModel(description = "")
public class Favourite {
  
  @SerializedName("airline")
  private String airline = null;

  /**
   **/
  @ApiModelProperty(value = "")
  public String getAirline() {
    return airline;
  }
  public void setAirline(String airline) {
    this.airline = airline;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Favourite favourite = (Favourite) o;
    return (this.airline == null ? favourite.airline == null : this.airline.equals(favourite.airline));
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + (this.airline == null ? 0: this.airline.hashCode());
    return result;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Favourite {\n");
    
    sb.append("  airline: ").append(airline).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
