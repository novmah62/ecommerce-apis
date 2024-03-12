package com.novmah.userservice.service.impl;

import com.novmah.basedomains.dto.SellerDto;
import com.novmah.userservice.domain.Seller;
import com.novmah.userservice.exception.ResourceNotFoundException;
import com.novmah.userservice.mapper.SellerMapper;
import com.novmah.userservice.repository.SellerRepository;
import com.novmah.userservice.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper mapper;

    @Override
    public SellerDto save(SellerDto sellerDto) {
        Seller seller = sellerRepository.save(mapper.map(sellerDto));
        return mapper.map(seller);
    }

    @Override
    public SellerDto findById(Integer id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "seller ID", id));
        return mapper.map(seller);
    }

    @Override
    public List<SellerDto> findAll() {
        List<Seller> sellers = sellerRepository.findAll();
        return sellers.stream().map(mapper::map).toList();
    }

    @Override
    public SellerDto update(SellerDto sellerDto) {
        if (!sellerRepository.existsById(sellerDto.getId()))
            throw new ResourceNotFoundException("Seller", "seller ID", sellerDto.getId());
        Seller seller = sellerRepository.save(mapper.map(sellerDto));
        return mapper.map(seller);
    }

    @Override
    public SellerDto getSellerByUserId(Integer userId) {
        Seller seller = sellerRepository.findSellerByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "user ID", userId));
        return mapper.map(seller);
    }

}
