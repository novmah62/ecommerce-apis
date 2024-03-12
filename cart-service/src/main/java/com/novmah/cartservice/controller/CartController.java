package com.novmah.cartservice.controller;

import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cart-service/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/buyer/{buyerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartItemDto> getCartByBuyerId(@PathVariable("buyerId") Integer id) {
        return cartService.getCartByBuyerId(id);
    }

    @GetMapping("/totalAmount/{buyerId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getTotalAmount(@PathVariable("buyerId") Integer id) {
        return cartService.getTotalAmount(id);
    }

    @GetMapping("/itemQuantity/{buyerId}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getItemQuantity(@PathVariable("buyerId") Integer id) {
        return cartService.getItemQuantity(id);
    }


}
