package com.novmah.orderservice.domain;

import com.novmah.basedomains.status.OrderItemStatus;
import com.novmah.basedomains.status.Status;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_items")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"order"})
public class OrderItem extends AbstractMappedEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    private String review;

    @Enumerated(EnumType.STRING)
    private Status reviewStatus;

    private Integer rating;

    @Enumerated(EnumType.STRING)
    private OrderItemStatus orderStatus;

    private LocalDateTime shippingDate;
    private LocalDateTime deliveredDate;
    private LocalDateTime reviewDate;

    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
