package com.novmah.cartservice.consumer;

import com.novmah.basedomains.dto.CartItemDto;
import com.novmah.basedomains.event.OrderEvent;
import com.novmah.cartservice.service.CartItemService;
import com.novmah.cartservice.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CartConsumer {

    private final CartService cartService;
    private final CartItemService cartItemService;

    @KafkaListener(
            topics = "order_topics",
            groupId = "cart")
    public void consume(OrderEvent event) {
        log.info("Buyer event received in cart service => {}", event.toString());
        for (CartItemDto cartItemDto : cartService.getCartByBuyerId(event.getOrderDto().getBuyerDto().getId())) {
            cartItemService.delete(cartItemDto.getId());
        }
    }

}
