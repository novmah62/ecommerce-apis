package com.novmah.orderservice.controller;

import com.novmah.basedomains.dto.OrderItemDto;
import com.novmah.orderservice.service.OrderItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-service/orderItem")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody OrderItemDto orderItemDto) {
        return orderItemService.save(orderItemDto);
    }

    @GetMapping("/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDto findById(@PathVariable("orderItemId") Integer id) {
        return orderItemService.findById(id);
    }

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemDto> findByProductId(@PathVariable("productId") Integer id) {
        return orderItemService.findByProductId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderItemDto> findAll() {
        return orderItemService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDto update(@Valid @RequestBody OrderItemDto orderItemDto) {
        return orderItemService.update(orderItemDto);
    }

    @DeleteMapping("/{orderItemId}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("orderItemId") Integer id) {
        return orderItemService.delete(id);
    }

}
