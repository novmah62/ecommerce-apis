package com.novmah.paymentservice.service.impl;

import com.novmah.basedomains.dto.PaymentDto;
import com.novmah.paymentservice.domain.Payment;
import com.novmah.paymentservice.exception.ResourceNotFoundException;
import com.novmah.paymentservice.mapper.PaymentMapper;
import com.novmah.paymentservice.repository.PaymentRepository;
import com.novmah.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    @Override
    public PaymentDto save(PaymentDto paymentDto) {
        Payment payment = paymentRepository.save(mapper.map(paymentDto));
        return mapper.map(payment);
    }

    @Override
    public PaymentDto findById(String id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "payment ID", id));
        return mapper.map(payment);
    }

    @Override
    public PaymentDto findByOrderId(Integer orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with order ID : " + orderId));
        return mapper.map(payment);
    }

    @Override
    public List<PaymentDto> findAll() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream().map(mapper::map).toList();
    }

    @Override
    public PaymentDto update(PaymentDto paymentDto) {
        Payment payment = paymentRepository.save(mapper.map(paymentDto));
        return mapper.map(payment);
    }

    @Override
    public void delete(String id) {
        paymentRepository.deleteById(id);
    }
}
