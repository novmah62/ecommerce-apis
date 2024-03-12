package com.novmah.userservice.service.impl;

import com.novmah.basedomains.dto.UserDto;
import com.novmah.userservice.domain.User;
import com.novmah.userservice.exception.ResourceNotFoundException;
import com.novmah.userservice.mapper.UserMapper;
import com.novmah.userservice.repository.UserRepository;
import com.novmah.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public String save(UserDto userDto) {
        userRepository.save(mapper.map(userDto));
        return "User saved successfully";
    }

    @Override
    public UserDto findById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "user ID", id));
        return mapper.map(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(mapper::map).toList();
    }

    @Override
    public UserDto update(UserDto userDto) {
        if (!userRepository.existsById(userDto.getId())) {
            throw new ResourceNotFoundException("User", "user ID", userDto.getId());
        }
        User user = userRepository.save(mapper.map(userDto));
        return mapper.map(user);
    }

    @Override
    public String delete(Integer id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }

    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmails(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email"));
        return mapper.map(user);
    }

}
