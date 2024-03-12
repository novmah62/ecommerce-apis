package com.novmah.cartservice.service.impl;

import com.novmah.basedomains.constant.AppConstant;
import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.cartservice.domain.CartItem;
import com.novmah.cartservice.exception.ResourceNotFoundException;
import com.novmah.cartservice.mapper.CartItemMapper;
import com.novmah.cartservice.repository.CartItemRepository;
import com.novmah.cartservice.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartItemMapper mapper;
    private final WebClient webClient;


    @Override
    public CartItemDto save(CartItemDto cartItemDto) {
        CartItem cartItem = cartItemRepository.save(mapper.map(cartItemDto));
        return mapper.map(cartItem,
                callProductService(cartItem.getProductId()),
                callBuyerService(cartItem.getBuyerId()));
    }

    @Override
    public CartItemDto findById(String id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item", "cart item ID", id));
        return mapper.map(cartItem,
                callProductService(cartItem.getProductId()),
                callBuyerService(cartItem.getBuyerId()));
    }

    @Override
    public List<CartItemDto> findAll() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return cartItems.stream()
                .map(mapper::map)
                .peek(f -> {
                    f.setProductDto(callProductService(f.getProductDto().getId()));
                    f.setBuyerDto(callBuyerService(f.getBuyerDto().getId()));
                })
                .toList();
    }

    @Override
    public void delete(String id) {
        cartItemRepository.deleteById(id);
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

    public BuyerDto callBuyerService(Integer buyerId) {
        try {
            return webClient.get()
                    .uri(AppConstant.BUYER_SERVICE_URL + buyerId)
                    .retrieve()
                    .bodyToMono(BuyerDto.class)
                    .block();
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Error calling product service: " + e);
        }
    }

}
