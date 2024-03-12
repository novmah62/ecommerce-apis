package com.novmah.advertservice.controller;

import com.novmah.advertservice.service.AdvertService;
import com.novmah.basedomains.dto.AdvertDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advert")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AdvertDto save(@Valid @RequestBody AdvertDto advertDto) {
        return advertService.save(advertDto);
    }

    @GetMapping("/{advertId}")
    @ResponseStatus(HttpStatus.OK)
    public AdvertDto findById(@PathVariable("advertId") String id) {
        return advertService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AdvertDto> findAll() {
        return advertService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AdvertDto update(@Valid @RequestBody AdvertDto advertDto) {
        return advertService.update(advertDto);
    }

    @DeleteMapping("/{advertId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("advertId") String id) {
        advertService.delete(id);
    }

}
