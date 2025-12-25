package com.example.letters.service;

import com.example.letters.model.Letter;
import com.example.letters.model.User;
import com.example.letters.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User getUserById(long id) {
        return userRepo.findById(id).orElseThrow();
    }
    public void addUser(User user) {
        userRepo.save(user);
    }
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }
    public List<Letter> getUserLetters(long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getLetters();
    }
}
