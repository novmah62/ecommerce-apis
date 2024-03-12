package com.novmah.advertservice.service.impl;

import com.novmah.advertservice.domain.Advert;
import com.novmah.advertservice.exception.ResourceNotFoundException;
import com.novmah.advertservice.mapper.AdvertMapper;
import com.novmah.advertservice.repository.AdvertRepository;
import com.novmah.advertservice.service.AdvertService;
import com.novmah.basedomains.dto.AdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertServiceImpl implements AdvertService {

    private final AdvertRepository advertRepository;
    private final AdvertMapper mapper;

    @Override
    public AdvertDto save(AdvertDto advertDto) {
        Advert advert = advertRepository.save(mapper.map(advertDto));
        return mapper.map(advert);
    }

    @Override
    public AdvertDto findById(String id) {
        Advert advert = advertRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Advert", "advert ID", id));
        return mapper.map(advert);
    }

    @Override
    public List<AdvertDto> findAll() {
        List<Advert> adverts = advertRepository.findAll();
        return adverts.stream().map(mapper::map).toList();
    }

    @Override
    public AdvertDto update(AdvertDto advertDto) {
        Advert advert = advertRepository.save(mapper.map(advertDto));
        return mapper.map(advert);
    }

    @Override
    public void delete(String id) {
        advertRepository.deleteById(id);
    }
}
