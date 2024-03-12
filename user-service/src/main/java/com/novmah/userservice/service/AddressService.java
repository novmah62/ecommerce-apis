package com.novmah.userservice.service;

import com.novmah.basedomains.dto.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto save(AddressDto addressDto);
    AddressDto findById(Integer id);
    List<AddressDto> findByUserId(Integer userId);
    List<AddressDto> findAll();
    AddressDto update(AddressDto addressDto);
    void delete(Integer id);


}
