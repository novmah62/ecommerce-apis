package com.novmah.productservice.repository;

import com.novmah.productservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryName(String name);
    List<Product> findBySellerId(Integer sellerId);
    List<Product> findByNameContaining(String name);

}
