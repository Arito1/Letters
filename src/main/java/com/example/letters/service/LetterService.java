package com.example.letters.service;


import com.example.letters.model.Letter;
import com.example.letters.repo.LetterRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {
    private final LetterRepo letterRepo;
    public LetterService(LetterRepo letterRepo) {
        this.letterRepo = letterRepo;
    }
    public List<Letter> getAllLetters() {
        return letterRepo.findAll();
    }
    public Letter getLetterById(long id) {
        return letterRepo.findById(id).orElseThrow();
    }
    public void addLetter(Letter letter) {
        letterRepo.save(letter);
    }
    public void deleteLetterById(long id) {
        letterRepo.deleteById(id);
    }
}
