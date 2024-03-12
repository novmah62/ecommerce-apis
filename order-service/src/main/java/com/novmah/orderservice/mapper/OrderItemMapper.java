package com.novmah.orderservice.mapper;

import com.novmah.basedomains.dto.OrderItemDto;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.orderservice.domain.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "productId", target = "productDto.id")
    @Mapping(source = "order", target = "orderDto")
    OrderItemDto map(OrderItem orderItem);

    @Mapping(source = "orderItem.id", target = "id")
    @Mapping(source = "orderItem.quantity", target = "quantity")
    @Mapping(source = "productDto", target = "productDto")
    @Mapping(source = "orderItem.order", target = "orderDto")
    OrderItemDto map(OrderItem orderItem, ProductDto productDto);

    @Mapping(source = "productDto.id", target = "productId")
    @Mapping(source = "orderDto", target = "order")
    OrderItem map(OrderItemDto orderItemDto);

}
