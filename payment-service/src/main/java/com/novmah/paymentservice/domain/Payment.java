package com.novmah.paymentservice.domain;

import com.novmah.basedomains.status.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Payment extends AbstractMappedEntity implements Serializable {

    @Id
    @Column(unique = true, nullable = false, updatable = false)
    private String id;

    private Integer orderId;

    private Boolean isPayed;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

}
