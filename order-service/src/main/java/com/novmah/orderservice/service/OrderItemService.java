package com.novmah.orderservice.service;

import com.novmah.basedomains.dto.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    String save(OrderItemDto orderItemDto);
    OrderItemDto findById(Integer id);
    List<OrderItemDto> findByProductId(Integer productId);
    List<OrderItemDto> findAll();
    OrderItemDto update(OrderItemDto orderItemDto);
    String delete(Integer id);

}
