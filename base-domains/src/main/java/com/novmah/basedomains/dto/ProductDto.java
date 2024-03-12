package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String name;

    @NotBlank(message = "Image URL cannot be blank")
    @URL(message = "Image URL is not valid")
    private String imageUrl;

    @NotBlank(message = "SKU cannot be blank")
    @Size(max = 20, message = "SKU cannot exceed 20 characters")
    private String sku;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price cannot be negative")
    private BigDecimal price;

    @NotNull(message = "Quantity cannot be null")
    @Min(value = 1, message = "Quantity must be a positive integer")
    private Integer quantity;

    @JsonProperty("seller")
    @JsonInclude(NON_NULL)
    private SellerDto sellerDto;

    @JsonProperty("category")
    @JsonInclude(NON_NULL)
    private CategoryDto categoryDto;

}
