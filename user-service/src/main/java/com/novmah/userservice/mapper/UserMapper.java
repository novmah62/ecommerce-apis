package com.novmah.userservice.mapper;

import com.novmah.basedomains.dto.UserDto;
import com.novmah.userservice.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto map(User user);
    User map(UserDto userDto);

}
