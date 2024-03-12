package com.novmah.orderservice.mapper;

import com.novmah.basedomains.dto.AddressDto;
import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.basedomains.dto.OrderDto;
import com.novmah.basedomains.dto.PaymentDto;
import com.novmah.orderservice.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "buyerId", target = "buyerDto.id")
    @Mapping(source = "shippingAddressId", target = "shippingAddressDto.id")
    @Mapping(source = "billingAddressId", target = "billingAddressDto.id")
    @Mapping(source = "paymentId", target = "paymentDto.id")
    @Mapping(source = "orderItems", target = "orderItemDtoList")
    OrderDto map(Order order);


    @Mapping(source = "buyerDto", target = "buyerDto")
    @Mapping(source = "shippingAddressDto", target = "shippingAddressDto")
    @Mapping(source = "billingAddressDto", target = "billingAddressDto")
    @Mapping(source = "paymentDto", target = "paymentDto")
    @Mapping(source = "order.id", target = "id")
    @Mapping(source = "order.status", target = "status")
    @Mapping(source = "order.orderItems", target = "orderItemDtoList")
    OrderDto map(Order order, BuyerDto buyerDto, AddressDto shippingAddressDto, AddressDto billingAddressDto, PaymentDto paymentDto);

    @Mapping(source = "buyerDto.id", target = "buyerId")
    @Mapping(source = "shippingAddressDto.id", target = "shippingAddressId")
    @Mapping(source = "billingAddressDto.id", target = "billingAddressId")
    @Mapping(source = "paymentDto.id", target = "paymentId")
    @Mapping(source = "orderItemDtoList", target = "orderItems")
    Order map(OrderDto orderDto);

}
