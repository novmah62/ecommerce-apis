package com.novmah.paymentservice.mapper;

import com.novmah.basedomains.dto.PaymentDto;
import com.novmah.paymentservice.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto map(Payment payment);

    Payment map(PaymentDto paymentDto);

}
