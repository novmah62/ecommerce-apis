package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    private Integer id;

    @NotBlank(message = "Full address cannot be empty")
    private String fullAddress;

    @NotBlank(message = "Postal code cannot be empty")
    @Pattern(regexp = "[0-9]{5}", message = "Postal code must be a 5-digit number")
    private String postalCode;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @JsonProperty("user")
    @JsonInclude(NON_NULL)
    private UserDto userDto;

}
