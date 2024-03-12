package com.novmah.cartservice.service;

import com.novmah.basedomains.dto.CartItemDto;

import java.util.List;

public interface CartItemService {

    CartItemDto save(CartItemDto cartItemDto);
    CartItemDto findById(String id);
    List<CartItemDto> findAll();
    void delete(String id);

}
