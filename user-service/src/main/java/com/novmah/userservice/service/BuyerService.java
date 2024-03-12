package com.novmah.userservice.service;

import com.novmah.basedomains.dto.BuyerDto;

import java.util.List;

public interface BuyerService {

    BuyerDto save(BuyerDto buyerDto);
    BuyerDto findById(Integer id);
    List<BuyerDto> findAll();
    BuyerDto update(BuyerDto buyerDto);
    BuyerDto getBuyerByUserId(Integer userId);

}
