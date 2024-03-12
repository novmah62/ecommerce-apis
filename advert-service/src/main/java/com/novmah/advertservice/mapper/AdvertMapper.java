package com.novmah.advertservice.mapper;

import com.novmah.advertservice.domain.Advert;
import com.novmah.basedomains.dto.AdvertDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertMapper {

    AdvertDto map(Advert advert);

    Advert map(AdvertDto advertDto);

}
