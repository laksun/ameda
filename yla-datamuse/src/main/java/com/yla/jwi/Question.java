package com.yla.jwi;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "questions")
public class Question {
	
	@Id
	String id;
	String word;
	String meaning;
	String[]  synonyms;
	String pos;   //part of speech , noun, verb, adjective
	String[] choices;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String[] getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(String[] synonyms) {
		this.synonyms = synonyms;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "Question [id=" + id +", word=" + word + ", meaning=" + meaning + ", synonyms=" + Arrays.toString(synonyms) + ", pos="
				+ pos + ", choices=" + Arrays.toString(choices) + "]";
	}
	public String[] getChoices() {
		return choices;
	}
	public void setChoices(String[] choices) {
		this.choices = choices;
	}
	public Question(String id,String word, String meaning, String[] synonyms, String pos, String[] choices) {
		super();
		this.id = id;
		this.word = word;
		this.meaning = meaning;
		this.synonyms = synonyms;
		this.pos = pos;
		this.choices = choices;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
