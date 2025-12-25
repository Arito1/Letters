package com.example.letters.Mapper;

import com.example.letters.dto.UserDto;
import com.example.letters.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    User toUser(UserDto userDto);

    List<UserDto> toUserDtos(List<User> users);
}
