package com.example.letters.service;

import com.example.letters.model.Letter;
import com.example.letters.model.User;
import com.example.letters.repo.LetterRepo;
import com.example.letters.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final LetterRepo letterRepo;

    public UserService(UserRepo userRepo, LetterRepo letterRepo) {
        this.userRepo = userRepo;
        this.letterRepo = letterRepo;
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
    public Letter addLetterToUser(long userId, Letter letter) {
        User user = getUserById(userId);

        letter.setUser(user);
        user.getLetters().add(letter);

        return letterRepo.save(letter);
    }
}
