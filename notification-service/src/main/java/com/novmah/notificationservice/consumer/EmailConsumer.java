package com.novmah.notificationservice.consumer;

import com.novmah.basedomains.event.OrderEvent;
import com.novmah.notificationservice.dto.EmailDetails;
import com.novmah.notificationservice.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailConsumer {

    private final MailService mailService;

    @KafkaListener(
            topics = "order_topics",
            groupId = "email")
    public void consume(OrderEvent event) {

        log.info("Order event received in email service => {}", event.toString());

        mailService.sendEmail(EmailDetails.builder()
                .recipient(event.getOrderDto().getBuyerDto().getUserDto().getEmails())
                .subject("ORDER CREATION")
                .messageBody("Congratulations! Your order has been successfully created")
                .build());

    }

}
