package com.novmah.paymentservice.controller;

import com.novmah.basedomains.dto.PaymentDto;
import com.novmah.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-service/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDto save(@Valid @RequestBody PaymentDto advertDto) {
        return paymentService.save(advertDto);
    }

    @GetMapping("/{paymentId}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto findById(@PathVariable("paymentId") String id) {
        return paymentService.findById(id);
    }

    @GetMapping("/order/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto findByOrderId(@PathVariable("orderId") Integer id) {
        return paymentService.findByOrderId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentDto> findAll() {
        return paymentService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PaymentDto update(@Valid @RequestBody PaymentDto advertDto) {
        return paymentService.update(advertDto);
    }

    @DeleteMapping("/{paymentId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("paymentId") String id) {
        paymentService.delete(id);
    }


}
