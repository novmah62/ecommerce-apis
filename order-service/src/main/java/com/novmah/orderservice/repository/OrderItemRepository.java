package com.novmah.orderservice.repository;

import com.novmah.orderservice.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByProductId(Integer productId);

}
