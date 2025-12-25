package com.example.letters.controller;

import com.example.letters.dto.UserDto;
import com.example.letters.model.User;
import com.example.letters.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/letters")
    public String getLetterById(@PathVariable long userId) {
        return userService.getLetterById(userId);
    }

    @PatchMapping("/{userId}/letters")
    public User addLetter(
            @PathVariable long userId,
            @RequestBody Map<String, String> body
    ) {
        return userService.addLetterToUser(userId, body.get("letter"));
    }
}
