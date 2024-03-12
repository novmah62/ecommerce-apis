package com.novmah.orderservice.service.impl;

import com.novmah.basedomains.constant.AppConstant;
import com.novmah.basedomains.dto.OrderItemDto;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.orderservice.domain.OrderItem;
import com.novmah.orderservice.exception.ResourceNotFoundException;
import com.novmah.orderservice.mapper.OrderItemMapper;
import com.novmah.orderservice.repository.OrderItemRepository;
import com.novmah.orderservice.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper mapper;
    private final WebClient webClient;

    @Override
    public String save(OrderItemDto orderItemDto) {

        ProductDto productDto = callProductService(orderItemDto.getProductDto().getId());
        if (productDto == null || orderItemDto.getProductDto() == null)
            throw new ResourceNotFoundException("Order item not found with product ID");
        if (orderItemDto.getQuantity() > productDto.getQuantity())
            throw new ResourceNotFoundException("Product is not in stock, please try again later");

        orderItemRepository.save(mapper.map(orderItemDto));
        return "Order item saved successfully";
    }

    @Override
    public OrderItemDto findById(Integer id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order item", "order item ID", id));
        return mapper.map(orderItem, callProductService(orderItem.getProductId()));
    }

    @Override
    public List<OrderItemDto> findByProductId(Integer productId) {
        List<OrderItem> orderItems = orderItemRepository.findByProductId(productId);
        return orderItems.stream()
                .map(mapper::map)
                .peek(f -> f.setProductDto(callProductService(f.getProductDto().getId())))
                .toList();
    }

    @Override
    public List<OrderItemDto> findAll() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream()
                .map(mapper::map)
                .peek(f -> f.setProductDto(callProductService(f.getProductDto().getId())))
                .toList();
    }

    @Override
    public OrderItemDto update(OrderItemDto orderItemDto) {
        if (!orderItemRepository.existsById(orderItemDto.getId()))
            throw new ResourceNotFoundException("Order item", "order item ID", orderItemDto.getId());
        OrderItem orderItem = orderItemRepository.save(mapper.map(orderItemDto));
        return mapper.map(orderItem, callProductService(orderItem.getProductId()));
    }

    @Override
    public String delete(Integer id) {
        orderItemRepository.deleteById(id);
        return "Order item deleted successfully";
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
