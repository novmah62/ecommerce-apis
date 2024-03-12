package com.novmah.basedomains.dto;

import com.novmah.basedomains.status.PaymentStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {

    private String id;

    @NotNull(message = "orderId cannot be empty")
    private Integer orderId;

    @NotNull(message = "Payment status cannot be null")
    private Boolean isPayed;

    private PaymentStatus status;

}
