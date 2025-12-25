package com.example.letters.controller;

import com.example.letters.model.Letter;
import com.example.letters.model.User;
import com.example.letters.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{userId}/letters")
    public List<Letter> getUserLetters(@PathVariable long userId) {
        return userService.getUserLetters(userId);
    }

    @PostMapping("/users/{userId}/letters")
    public Letter addLetter(
            @PathVariable long userId,
            @RequestBody Letter letter
    ) {
        return userService.addLetterToUser(userId, letter);
    }
}
