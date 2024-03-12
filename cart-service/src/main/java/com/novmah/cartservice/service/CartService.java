package com.novmah.cartservice.service;

import com.novmah.basedomains.dto.CartItemDto;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {

    List<CartItemDto> getCartByBuyerId(Integer id);
    BigDecimal getTotalAmount(Integer buyerId);
    Integer getItemQuantity(Integer buyerId);

}
