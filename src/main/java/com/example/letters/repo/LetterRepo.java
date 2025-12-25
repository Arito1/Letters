package com.example.letters.repo;

import com.example.letters.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LetterRepo extends JpaRepository<Letter, Long> {
}
