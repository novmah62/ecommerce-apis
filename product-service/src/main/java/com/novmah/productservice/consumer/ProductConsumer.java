package com.novmah.productservice.consumer;

import com.novmah.basedomains.dto.OrderItemDto;
import com.novmah.basedomains.event.OrderEvent;
import com.novmah.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductConsumer {

    private final ProductService productService;

    @KafkaListener(
            topics = "order_topics",
            groupId = "product")
    public void consume(OrderEvent event) {
        log.info("Order item event received in product service => {}", event.toString());
        // update quantity product
        for (OrderItemDto orderItemDto : event.getOrderDto().getOrderItemDtoList()) {
            productService.updateQuantity(orderItemDto.getProductDto().getId(), orderItemDto.getQuantity());
        }
    }

}
