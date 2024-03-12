package com.novmah.userservice.service;

import com.novmah.basedomains.dto.UserDto;

import java.util.List;

public interface UserService {

    String save(UserDto userDto);
    UserDto findById(Integer id);
    List<UserDto> findAll();
    UserDto update(UserDto userDto);
    String delete(Integer id);
    UserDto findByEmail(String email);

}
