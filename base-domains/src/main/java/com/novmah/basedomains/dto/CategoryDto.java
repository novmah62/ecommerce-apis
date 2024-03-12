package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {

    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    @Length(max = 1024, message = "Description cannot exceed 1024 characters")
    private String description;

    @JsonInclude(NON_NULL)
    private Set<CategoryDto> subCategoriesDto;

    @JsonProperty("parentCategory")
    @JsonInclude(NON_NULL)
    private CategoryDto parentCategoryDto;

    @JsonProperty("products")
    @JsonInclude(NON_NULL)
    private Set<ProductDto> productDtoSet;

}
