package com.novmah.userservice.mapper;

import com.novmah.basedomains.dto.SellerDto;
import com.novmah.userservice.domain.Seller;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    @Mapping(source = "user", target = "userDto")
    SellerDto map(Seller seller);

    @Mapping(source = "userDto", target = "user")
    Seller map(SellerDto sellerDto);

}
