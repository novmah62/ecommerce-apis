package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novmah.basedomains.status.OrderItemStatus;
import com.novmah.basedomains.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto implements Serializable {

    private Integer id;

    private Integer quantity;

    private String review;

    private Status reviewStatus;

    private Integer rating;

    private OrderItemStatus orderStatus;

    private LocalDateTime shippingDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime reviewDate;

    @JsonProperty("product")
    @JsonInclude(NON_NULL)
    private ProductDto productDto;

    @JsonProperty("order")
    @JsonInclude(NON_NULL)
    private OrderDto orderDto;

}
