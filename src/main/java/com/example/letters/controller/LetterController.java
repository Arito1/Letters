package com.example.letters.controller;

import com.example.letters.model.Letter;
import com.example.letters.service.LetterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/letters")
public class LetterController {

    private final LetterService letterService;

    public LetterController(LetterService letterService) {
        this.letterService = letterService;
    }

    @GetMapping
    public List<Letter> getAllLetters() {
        return letterService.getAllLetters();
    }

    @GetMapping("/{id}")
    public Letter getLetterById(@PathVariable long id) {
        return letterService.getLetterById(id);
    }

    @PostMapping
    public void addLetter(@RequestBody Letter letter) {
        letterService.addLetter(letter);
    }

    @DeleteMapping("/{id}")
    public void deleteLetter(@PathVariable long id) {
        letterService.deleteLetterById(id);
    }
}
