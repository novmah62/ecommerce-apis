package com.novmah.userservice.mapper;

import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.userservice.domain.Buyer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BuyerMapper {

    @Mapping(source = "user", target = "userDto")
    BuyerDto map(Buyer buyer);

    @Mapping(source = "userDto", target = "user")
    Buyer map(BuyerDto buyerDto);

}
