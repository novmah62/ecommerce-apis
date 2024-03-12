package com.novmah.userservice.controller;

import com.novmah.basedomains.dto.BuyerDto;
import com.novmah.userservice.service.BuyerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-service/buyer")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BuyerDto save(@Valid @RequestBody BuyerDto buyerDto) {
        return buyerService.save(buyerDto);
    }

    @GetMapping("/{buyerId}")
    @ResponseStatus(HttpStatus.OK)
    public BuyerDto findById(@PathVariable("buyerId") Integer id) {
        return buyerService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BuyerDto> findAll() {
        return buyerService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public BuyerDto update(@Valid @RequestBody BuyerDto buyerDto) {
        return buyerService.update(buyerDto);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public BuyerDto getBuyerByUserId(@PathVariable("userId") Integer userId) {
        return buyerService.getBuyerByUserId(userId);
    }

}
