package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.novmah.basedomains.status.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SellerDto implements Serializable {

    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private String name;

    @Length(max = 1024, message = "Description cannot exceed 1024 characters")
    private String description;

    @NotBlank(message = "Picture URL cannot be blank")
    @URL(message = "Picture URL is not valid")
    private String picture;

    private Status status;

    @JsonProperty("user")
    private UserDto userDto;

}
