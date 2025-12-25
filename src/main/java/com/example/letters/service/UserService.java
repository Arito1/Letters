package com.example.letters.service;

import com.example.letters.Mapper.UserMapper;
import com.example.letters.dto.UserDto;
import com.example.letters.model.User;
import com.example.letters.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    public UserService(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public List<UserDto> getAllUsers() {
        return userMapper.toUserDtos(userRepo.findAll());
    }
    public UserDto getUserById(Long id) {
        return userMapper.toUserDto(userRepo.findById(id).orElseThrow());
    }
    public void addUser(UserDto user) {
        userRepo.save(userMapper.toUser(user));
    }
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
    public String getLetterById(Long id) {
        return userRepo.findById(id).orElseThrow().getLetter();
    }
    public User addLetterToUser(Long userId, String letter) {
        User user = userRepo.findById(userId).orElseThrow();
        user.setLetter(letter);
        return userRepo.save(user);
    }
}
