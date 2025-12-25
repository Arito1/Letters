package com.example.letters.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    long id;
    String usernameDto;
    String passwordDto;
    String letterDto;
}
