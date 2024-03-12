package com.novmah.userservice.service.impl;

import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.userservice.domain.Buyer;
import com.novmah.userservice.exception.ResourceNotFoundException;
import com.novmah.userservice.mapper.BuyerMapper;
import com.novmah.userservice.repository.BuyerRepository;
import com.novmah.userservice.service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository buyerRepository;
    private final BuyerMapper mapper;

    @Override
    public BuyerDto save(BuyerDto buyerDto) {
        Buyer buyer = buyerRepository.save(mapper.map(buyerDto));
        return mapper.map(buyer);
    }

    @Override
    public BuyerDto findById(Integer id) {
        Buyer buyer = buyerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "buyer ID", id));
        return mapper.map(buyer);
    }

    @Override
    public List<BuyerDto> findAll() {
        List<Buyer> buyers = buyerRepository.findAll();
        return buyers.stream().map(mapper::map).toList();
    }

    @Override
    public BuyerDto update(BuyerDto buyerDto) {
        if (buyerRepository.existsById(buyerDto.getId()))
            throw new ResourceNotFoundException("Buyer", "buyer ID", buyerDto.getId());
        Buyer buyer = buyerRepository.save(mapper.map(buyerDto));
        return mapper.map(buyer);
    }

    @Override
    public BuyerDto getBuyerByUserId(Integer userId) {
        Buyer buyer = buyerRepository.findBuyerByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "user ID", userId));
        return mapper.map(buyer);
    }

}
