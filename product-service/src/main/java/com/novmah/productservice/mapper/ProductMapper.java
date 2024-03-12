package com.novmah.productservice.mapper;

import com.novmah.basedomains.dto.ProductDto;
import com.novmah.basedomains.dto.SellerDto;
import com.novmah.productservice.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category", target = "categoryDto")
    @Mapping(source = "sellerId", target = "sellerDto.id")
    ProductDto map(Product product);

    @Mapping(source = "product.id", target = "id")
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.category", target = "categoryDto")
    @Mapping(source = "sellerDto", target = "sellerDto")
    ProductDto map(Product product, SellerDto sellerDto);

    @Mapping(source = "categoryDto", target = "category")
    @Mapping(source = "sellerDto.id", target = "sellerId")
    Product map(ProductDto productDto);

}
