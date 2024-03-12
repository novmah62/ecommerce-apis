package com.novmah.userservice.service;

import com.novmah.basedomains.dto.SellerDto;

import java.util.List;

public interface SellerService {

    SellerDto save(SellerDto sellerDto);
    SellerDto findById(Integer id);
    List<SellerDto> findAll();
    SellerDto update(SellerDto sellerDto);
    SellerDto getSellerByUserId(Integer userId);

}
