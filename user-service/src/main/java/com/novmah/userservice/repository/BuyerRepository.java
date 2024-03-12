package com.novmah.userservice.repository;

import com.novmah.userservice.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Optional<Buyer> findBuyerByUserId(Integer userId);
}
