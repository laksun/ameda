package com.yla.springboot.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class YLAFlashCard {

	@Id
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "word_name", nullable = false)
	private String wordName;
	
	@Column(name= "word_definition", nullable = false)
	private String wordDefinition;

	public YLAFlashCard() {
		super();
	}
	
	public YLAFlashCard(int id, String wordName, String wordDefinition) {
		super();
		this.id = id;
		this.wordName = wordName;
		this.wordDefinition = wordDefinition;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        YLAFlashCard other = (YLAFlashCard) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
	
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + id;
	        return result;
	    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("YLAFlashcard [id=%s,  wordName=%s, wordDefinition=%s]", id, wordName, wordDefinition);
	}
	
	public String getWordName() {
		return wordName;
	}

	public void setWordName(String wordName) {
		this.wordName = wordName;
	}

	public String getWordDefinition() {
		return wordDefinition;
	}

	public void setWordDefinition(String wordDefinition) {
		this.wordDefinition = wordDefinition;
	}

}
