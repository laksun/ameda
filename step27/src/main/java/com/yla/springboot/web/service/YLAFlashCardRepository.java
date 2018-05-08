package com.yla.springboot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yla.springboot.web.model.YLAFlashCard;


@Repository
public interface YLAFlashCardRepository extends JpaRepository<YLAFlashCard, Integer> {
	
		
	List<YLAFlashCard> findByWordName(String word);

}
