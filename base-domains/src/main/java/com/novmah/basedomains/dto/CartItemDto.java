package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CartItemDto implements Serializable {

    private String id;

    private Integer quantity;

    @JsonProperty("product")
    @JsonInclude(NON_NULL)
    private ProductDto productDto;

    @JsonProperty("buyer")
    @JsonInclude(NON_NULL)
    private BuyerDto buyerDto;

}
