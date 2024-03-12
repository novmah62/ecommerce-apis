package com.novmah.basedomains.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.novmah.basedomains.status.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {

    private Integer id;

    private BigDecimal totalAmount;

    private OrderStatus status;

    private LocalDateTime orderedDate;
    private LocalDateTime endDate;

    @JsonProperty("buyer")
    @JsonInclude(NON_NULL)
    private BuyerDto buyerDto;

    @JsonProperty("shippingAddress")
    @JsonInclude(NON_NULL)
    private AddressDto shippingAddressDto;

    @JsonProperty("billingAddress")
    @JsonInclude(NON_NULL)
    private AddressDto billingAddressDto;

    @JsonProperty("payment")
    @JsonInclude(NON_NULL)
    private PaymentDto paymentDto;

    @JsonProperty("orderItems")
    @JsonInclude(NON_NULL)
    private List<OrderItemDto> orderItemDtoList;


}
