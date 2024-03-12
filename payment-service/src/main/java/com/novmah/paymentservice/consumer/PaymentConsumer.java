package com.novmah.paymentservice.consumer;

import com.novmah.basedomains.event.OrderEvent;
import com.novmah.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentConsumer {

    private final PaymentService paymentService;

    @KafkaListener(
            topics = "order_topics",
            groupId = "payment")
    public void consume(OrderEvent event) {

        log.info("Order event received in payment service => {}", event.toString());

        paymentService.save(event.getOrderDto().getPaymentDto());
    }

}
