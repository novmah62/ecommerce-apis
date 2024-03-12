package com.novmah.userservice.controller;

import com.novmah.basedomains.dto.UserDto;
import com.novmah.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-service/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@Valid @RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/{cartId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findById(@PathVariable("cartId") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserDto update(@Valid @RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("userId") Integer id) {
        return userService.delete(id);
    }

}
