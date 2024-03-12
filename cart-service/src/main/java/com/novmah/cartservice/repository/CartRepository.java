package com.novmah.cartservice.repository;

import com.novmah.cartservice.domain.CartItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<CartItem, String> {
    List<CartItem> getCartItemByBuyerId(Integer buyerId);
}
