package com.novmah.advertservice.service;

import com.novmah.basedomains.dto.AdvertDto;

import java.util.List;

public interface AdvertService {

    AdvertDto save(AdvertDto advertDto);
    AdvertDto findById(String id);
    List<AdvertDto> findAll();
    AdvertDto update(AdvertDto advertDto);
    void delete(String id);

}
