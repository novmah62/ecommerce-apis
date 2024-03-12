package com.novmah.userservice.controller;

import com.novmah.basedomains.dto.AddressDto;
import com.novmah.userservice.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-service/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto save(@Valid @RequestBody AddressDto addressDto) {
        return addressService.save(addressDto);
    }

    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDto findById(@PathVariable("addressId") Integer id) {
        return addressService.findById(id);
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDto> findByUserId(@PathVariable("userId") Integer id) {
        return addressService.findByUserId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public AddressDto update(@Valid @RequestBody AddressDto addressDto) {
        return addressService.update(addressDto);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("addressId") Integer id) {
        addressService.delete(id);
    }

}
