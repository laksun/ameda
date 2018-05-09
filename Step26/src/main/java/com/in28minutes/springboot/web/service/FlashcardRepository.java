package com.in28minutes.springboot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.web.model.Flashcard;

@Repository
public interface FlashcardRepository extends JpaRepository<Flashcard, Integer>{
	public List<Flashcard> findByWord(String word);

}
