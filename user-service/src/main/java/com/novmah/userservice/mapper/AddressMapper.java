package com.novmah.userservice.mapper;

import com.novmah.basedomains.dto.AddressDto;
import com.novmah.userservice.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "user", target = "userDto")
    AddressDto map(Address address);

    @Mapping(source = "userDto", target = "user")
    Address map(AddressDto addressDto);

}
