package com.novmah.cartservice.service.impl;

import com.novmah.basedomains.constant.AppConstant;
import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.cartservice.domain.CartItem;
import com.novmah.cartservice.exception.ResourceNotFoundException;
import com.novmah.cartservice.mapper.CartItemMapper;
import com.novmah.cartservice.repository.CartRepository;
import com.novmah.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemMapper cartItemMapper;
    private final WebClient webClient;

    @Override
    public List<CartItemDto> getCartByBuyerId(Integer buyerId) {
        List<CartItem> cartItems = cartRepository.getCartItemByBuyerId(buyerId);
        return cartItems.stream()
                .map(cartItemMapper::map)
                .peek(f -> {
                    f.setProductDto(callProductService(f.getProductDto().getId()));
                    f.setBuyerDto(callBuyerService(f.getBuyerDto().getId()));
                })
                .toList();
    }

    @Override
    public BigDecimal getTotalAmount(Integer buyerId) {
        List<CartItem> cartItems = cartRepository.getCartItemByBuyerId(buyerId);
        BigDecimal totalAmount = new BigDecimal("0.00");
        for (CartItem item : cartItems) {
            totalAmount = totalAmount.add(callProductService(item.getProductId()).getPrice()
                    .multiply(new BigDecimal(item.getQuantity())));
        }
        return totalAmount;
    }

    @Override
    public Integer getItemQuantity(Integer buyerId) {
        List<CartItem> cartItems = cartRepository.getCartItemByBuyerId(buyerId);
        return cartItems.size();
    }

    public BuyerDto callBuyerService(Integer buyerId) {
        try {
            return webClient.get()
                    .uri(AppConstant.BUYER_SERVICE_URL + buyerId)
                    .retrieve()
                    .bodyToMono(BuyerDto.class)
                    .block();
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Error calling buyer service: " + e);
        }
    }

    public ProductDto callProductService(Integer productId) {
        try {
            return webClient.get()
                    .uri(AppConstant.PRODUCT_SERVICE_URL + productId)
                    .retrieve()
                    .bodyToMono(ProductDto.class)
                    .block();
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Error calling product service: " + e);
        }
    }

}
