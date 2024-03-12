package com.novmah.productservice.service.impl;

import com.novmah.basedomains.constant.AppConstant;
import com.novmah.basedomains.dto.ProductDto;
import com.novmah.basedomains.dto.SellerDto;
import com.novmah.productservice.exception.ResourceNotFoundException;
import com.novmah.productservice.mapper.ProductMapper;
import com.novmah.productservice.domain.Product;
import com.novmah.productservice.repository.ProductRepository;
import com.novmah.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;
    private final WebClient webClient;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productRepository.save(mapper.map(productDto));
        return mapper.map(product, callSellerService(product.getSellerId()));
    }

    @Override
    @SneakyThrows
    public ProductDto findById(Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "product ID", id));
        return mapper.map(product, callSellerService(product.getSellerId()));
    }

    @Override
    public List<ProductDto> searchProducts(String keyword) {
        List<Product> products = productRepository.findByNameContaining(keyword);
        return products.stream()
                .map(mapper::map)
                .peek(f -> f.setSellerDto(callSellerService(f.getSellerDto().getId())))
                .toList();
    }

    @Override
    public List<ProductDto> findByCategoryName(String name) {
        List<Product> products = productRepository.findByCategoryName(name);
        return products.stream()
                .map(mapper::map)
                .peek(f -> f.setSellerDto(callSellerService(f.getSellerDto().getId())))
                .toList();
    }

    @Override
    public List<ProductDto> findBySellerId(Integer sellerId) {
        List<Product> products = productRepository.findBySellerId(sellerId);
        return products.stream()
                .map(mapper::map)
                .peek(f -> f.setSellerDto(callSellerService(f.getSellerDto().getId())))
                .toList();
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(mapper::map)
                .peek(f -> f.setSellerDto(callSellerService(f.getSellerDto().getId())))
                .toList();
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if (!productRepository.existsById(productDto.getId())) {
            throw new ResourceNotFoundException("Product", "product ID", productDto.getId());
        }
        Product product = productRepository.save(mapper.map(productDto));
        return mapper.map(product, callSellerService(product.getSellerId()));
    }

    @Override
    public String deleteById(Integer id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public void updateQuantity(Integer id, Integer quantity) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "product ID", id));

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    public SellerDto callSellerService(Integer sellerId) {
        try {
            return webClient.get()
                    .uri(AppConstant.SELLER_SERVICE_URL + sellerId)
                    .retrieve()
                    .bodyToMono(SellerDto.class)
                    .block();
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Error calling seller service: " + e);
        }
    }

}
