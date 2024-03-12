package com.novmah.productservice.service;

import com.novmah.basedomains.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);
    ProductDto findById(Integer id);
    List<ProductDto> searchProducts(String keyword);
    List<ProductDto> findByCategoryName(String name);
    List<ProductDto> findBySellerId(Integer sellerId);
    List<ProductDto> findAll();
    ProductDto update(ProductDto productDto);
    String deleteById(Integer id);

    void updateQuantity(Integer id, Integer quantity);


}
