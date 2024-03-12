package com.novmah.paymentservice.service;

import com.novmah.basedomains.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto save(PaymentDto paymentDto);
    PaymentDto findById(String id);
    PaymentDto findByOrderId(Integer orderId);
    List<PaymentDto> findAll();
    PaymentDto update(PaymentDto paymentDto);
    void delete(String id);


}
