package com.novmah.cartservice.repository;

import com.novmah.cartservice.domain.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartItemRepository extends MongoRepository<CartItem, String> {
}
