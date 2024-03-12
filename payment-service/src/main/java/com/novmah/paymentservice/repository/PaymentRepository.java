package com.novmah.paymentservice.repository;

import com.novmah.paymentservice.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByOrderId(Integer orderId);

}
