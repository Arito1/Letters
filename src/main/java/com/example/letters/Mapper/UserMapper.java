package com.example.letters.Mapper;

import com.example.letters.dto.UserDto;
import com.example.letters.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "usernameDto", source = "username")
    @Mapping(target = "passwordDto", source = "password")
    @Mapping(target = "letterDto", source = "letter")
    UserDto toUserDto(User user);

    @Mapping(target = "username", source = "usernameDto")
    @Mapping(target = "password", source = "passwordDto")
    @Mapping(target = "letter", source = "letterDto")
    User toUser(UserDto userDto);

    List<UserDto> toUserDtos(List<User> users);
}
