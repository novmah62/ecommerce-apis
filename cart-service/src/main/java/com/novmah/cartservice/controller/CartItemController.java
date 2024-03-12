package com.novmah.cartservice.controller;

import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.cartservice.service.CartItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-service/cartItem")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartItemDto save(@Valid @RequestBody CartItemDto cartItemDto) {
        return cartItemService.save(cartItemDto);
    }

    @GetMapping("/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public CartItemDto findById(@PathVariable("cartItemId") String id) {
        return cartItemService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CartItemDto> findAll() {
        return cartItemService.findAll();
    }

    @DeleteMapping("/{cartItemId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("cartItemId") String id) {
        cartItemService.delete(id);
    }

}
