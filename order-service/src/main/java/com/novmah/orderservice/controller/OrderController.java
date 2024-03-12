package com.novmah.orderservice.controller;

import com.novmah.basedomains.dto.OrderDto;
import com.novmah.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-service/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveByCart(@Valid @RequestBody OrderDto orderDto) {
        return orderService.saveByCart(orderDto);
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto findById(@PathVariable("orderId") Integer id) {
        return orderService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@Valid @RequestBody OrderDto orderDto) {
        return orderService.update(orderDto);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("orderId") Integer id) {
        return orderService.delete(id);
    }

}
