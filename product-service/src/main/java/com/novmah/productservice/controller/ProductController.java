package com.novmah.productservice.controller;

import com.novmah.basedomains.dto.ProductDto;
import com.novmah.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-service/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto save(@Valid @RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto findById(@PathVariable("productId") Integer id) {
        return productService.findById(id);
    }

    @GetMapping("/search/{keyword}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> search(@PathVariable("keyword") String keyword) {
        return productService.searchProducts(keyword);
    }

    @GetMapping("/category/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findByCategoryName(@PathVariable("categoryName") String categoryName) {
        return productService.findByCategoryName(categoryName);
    }

    @GetMapping("/seller/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findByCategoryName(@PathVariable("sellerId") Integer id) {
        return productService.findBySellerId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductDto update(@Valid @RequestBody ProductDto productDto) {
        return productService.update(productDto);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteById(@PathVariable("productId") Integer id) {
        return productService.deleteById(id);
    }

}
