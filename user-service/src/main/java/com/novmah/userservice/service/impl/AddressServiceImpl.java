package com.novmah.userservice.service.impl;

import com.novmah.basedomains.dto.AddressDto;
import com.novmah.userservice.domain.Address;
import com.novmah.userservice.exception.ResourceNotFoundException;
import com.novmah.userservice.mapper.AddressMapper;
import com.novmah.userservice.repository.AddressRepository;
import com.novmah.userservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper mapper;

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = mapper.map(addressDto);
        addressRepository.save(address);
        return mapper.map(address);
    }

    @Override
    public AddressDto findById(Integer id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "address ID", id));
        return mapper.map(address);
    }

    @Override
    public List<AddressDto> findByUserId(Integer userId) {
        List<Address> addresses = addressRepository.findByUserId(userId);
        return addresses.stream().map(mapper::map).toList();
    }

    @Override
    public List<AddressDto> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(mapper::map).toList();
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        if (!addressRepository.existsById(addressDto.getId())) {
            throw new ResourceNotFoundException("Address", "address ID", addressDto.getId());
        }
        Address address = addressRepository.save(mapper.map(addressDto));
        return mapper.map(address);
    }

    @Override
    public void delete(Integer id) {
        addressRepository.deleteById(id);
    }

}
