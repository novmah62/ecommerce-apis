package com.novmah.basedomains.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private Integer id;

    @NotBlank(message = "First name cannot be blank")
    @NotNull(message = "First name cannot be null")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    private String lastName;

    @NotBlank(message = "Image cannot be blank")
    @URL(message = "Image URL is not valid")
    private String imageUrl;

    @Email(message = "Email is invalid")
    private String emails;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number is invalid")
    private String phone;

}
