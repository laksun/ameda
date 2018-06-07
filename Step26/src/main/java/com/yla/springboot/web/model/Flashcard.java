package com.yla.springboot.web.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="All details about flashcard")
public class Flashcard {
	
	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Size(min=1)
	@ApiModelProperty(notes="word should have atleast 1 character")
	private String word;

	@Size(min=1)
	@ApiModelProperty(notes="definition should have at least 1 character")
	private String definition;

	@Size(min=1)
	private String type;

	// the definition order
	@Digits(integer=3, fraction = 2, message="Please enter a digit between 1-999")
	private int wordorder;

	@JsonIgnore
	private String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Flashcard() {
		super();
	}

	public Flashcard(int id, String word, String definition, String type, int order) {
		super();
		this.id = id;
		this.word = word;
		this.definition = definition;
		this.type = type;
		this.wordorder = order;

	}

	@Override
	public String toString() {
		
		return String.format("word %s, definition %s, type %s, order %i, id %i", this.word, this.definition, this.type, this.wordorder, this.id);
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

	public int getWordorder() {
		return wordorder;
	}

	public void setWordorder(int wordorder) {
		this.wordorder = wordorder;
	}

	

	

}
