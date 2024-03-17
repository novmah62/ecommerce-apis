package com.novmah.orderservice.service;

import com.novmah.basedomains.dto.OrderDto;

import java.util.List;

public interface OrderService {

    String saveByCart(OrderDto orderDto);
    OrderDto findById(Integer id);
    List<OrderDto> findAll();
    OrderDto update(OrderDto orderDto);
    String delete(Integer id);

}
