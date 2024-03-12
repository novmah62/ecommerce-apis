package com.novmah.cartservice.mapper;

import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.cartservice.domain.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    @Mapping(source = "productId", target = "productDto.id")
    @Mapping(source = "buyerId", target = "buyerDto.id")
    CartItemDto map(CartItem cartItem);

    @Mapping(source = "productDto", target = "productDto")
    @Mapping(source = "buyerDto", target = "buyerDto")
    @Mapping(source = "cartItem.id", target = "id")
    @Mapping(source = "cartItem.quantity", target = "quantity")
    CartItemDto map(CartItem cartItem, ProductDto productDto, BuyerDto buyerDto);

    @Mapping(source = "productDto.id", target = "productId")
    @Mapping(source = "buyerDto.id", target = "buyerId")
    CartItem map(CartItemDto cartItemDto);

}
