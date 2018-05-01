package com.yla.survey.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yla.survey.model.Question;
import com.yla.survey.service.SurveyService;

   

@RestController
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestions(@PathVariable String surveyId){
		
		return surveyService.retrieveQuestions(surveyId);
		
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable String questionId){
		
		return surveyService.retrieveQuestion(surveyId, questionId);
		
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<?> saveQuestion(@PathVariable String surveyId, @RequestBody Question question){
		
		 Question newQuestion = surveyService.addQuestion(surveyId, question);
		 
		 if (newQuestion == null ) {
			 return ResponseEntity.noContent().build();
		 }
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newQuestion.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();
		
	}
	
	

}
