package com.novmah.userservice.repository;

import com.novmah.userservice.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Optional<Seller> findSellerByUserId(Integer userId);
}
