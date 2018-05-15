package com.in28minutes.springboot.web.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.springboot.web.exception.FlashCardNotFoundException;
import com.in28minutes.springboot.web.model.Flashcard;
import com.in28minutes.springboot.web.model.Todo;
import com.in28minutes.springboot.web.service.FlashcardRepository;

@RestController
public class FlashCardResource {

	@Autowired
	private FlashcardRepository flashCardRepository;

	@GetMapping("/flashcard/allflashcards")
	public List<Flashcard> retrieveAllFlashCards() {
		return flashCardRepository.findAll();
	}

	@GetMapping("/flashcard/oneflashcard/{id}")
	public Flashcard getFlashCard(@PathVariable int id) {

		Flashcard flashcard = flashCardRepository.findOne(id);

		if (flashcard == null) {
			throw new FlashCardNotFoundException();
		}

		return flashcard;
	}

	@DeleteMapping("/flashcard/oneflashcard/{id}")
	public Flashcard deleteFlashCard(@PathVariable int id) {

		Flashcard flashcard = flashCardRepository.findOne(id);

		if (flashcard == null) {
			throw new FlashCardNotFoundException();
		}

		flashCardRepository.delete(id);

		return flashcard;
	}

	@PostMapping("/flashcard/addflashcard")
	public ResponseEntity<Object> createFlashCard(@RequestBody Flashcard flashcard) {
		Flashcard savedFlashCard = flashCardRepository.save(flashcard);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedFlashCard.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
