package com.novmah.userservice.controller;

import com.novmah.basedomains.dto.SellerDto;
import com.novmah.userservice.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-service/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SellerDto save(@Valid @RequestBody SellerDto sellerDto) {
        return sellerService.save(sellerDto);
    }

    @GetMapping("/{sellerId}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDto findById(@PathVariable("sellerId") Integer id) {
        return sellerService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SellerDto> findAll() {
        return sellerService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SellerDto update(@Valid @RequestBody SellerDto sellerDto) {
        return sellerService.update(sellerDto);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public SellerDto getSellerByUserId(@PathVariable("userId") Integer userId) {
        return sellerService.getSellerByUserId(userId);
    }

}
