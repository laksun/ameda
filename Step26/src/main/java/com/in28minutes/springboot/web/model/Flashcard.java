package com.in28minutes.springboot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

@Entity
public class Flashcard {

	private String word;

	private String definition;

	private String type;

	// the definition order
	@Digits(integer=3, fraction = 2, message="Please enter a digit between 1-999")
	private int order;

	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	public Flashcard() {
		super();
	}

	public Flashcard(int id, String word, String definition, String type, int order) {
		super();
		this.id = id;
		this.word = word;
		this.definition = definition;
		this.type = type;
		this.order = order;

	}

	@Override
	public String toString() {
		
		return String.format("word %s, definition %s, type %s, order %i, id %i", this.word, this.definition, this.type, this.order, this.id);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result +id;
		return result;
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	

}
