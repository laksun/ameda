package com.yla.springboot.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ylaword {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Override
	public String toString() {
		return "Ylaword [id=" + id + ", wordName=" + wordName + ", wordType=" + wordType + ", wordDefinition="
				+ wordDefinition + ", wordExampleSentence=" + wordExampleSentence + "]";
	}
	public Ylaword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ylaword(int id, String wordName, String wordType, String wordDefinition, String wordExampleSentence) {
		super();
		this.id = id;
		this.wordName = wordName;
		this.wordType = wordType;
		this.wordDefinition = wordDefinition;
		this.wordExampleSentence = wordExampleSentence;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((wordDefinition == null) ? 0 : wordDefinition.hashCode());
		result = prime * result + ((wordExampleSentence == null) ? 0 : wordExampleSentence.hashCode());
		result = prime * result + ((wordName == null) ? 0 : wordName.hashCode());
		result = prime * result + ((wordType == null) ? 0 : wordType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ylaword other = (Ylaword) obj;
		if (id != other.id)
			return false;
		if (wordDefinition == null) {
			if (other.wordDefinition != null)
				return false;
		} else if (!wordDefinition.equals(other.wordDefinition))
			return false;
		if (wordExampleSentence == null) {
			if (other.wordExampleSentence != null)
				return false;
		} else if (!wordExampleSentence.equals(other.wordExampleSentence))
			return false;
		if (wordName == null) {
			if (other.wordName != null)
				return false;
		} else if (!wordName.equals(other.wordName))
			return false;
		if (wordType == null) {
			if (other.wordType != null)
				return false;
		} else if (!wordType.equals(other.wordType))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public String getWordType() {
		return wordType;
	}
	public void setWordType(String wordType) {
		this.wordType = wordType;
	}
	public String getWordDefinition() {
		return wordDefinition;
	}
	public void setWordDefinition(String wordDefinition) {
		this.wordDefinition = wordDefinition;
	}
	public String getWordExampleSentence() {
		return wordExampleSentence;
	}
	public void setWordExampleSentence(String wordExampleSentence) {
		this.wordExampleSentence = wordExampleSentence;
	}
	private String wordName;
	private String wordType;
    private String wordDefinition;
    private String wordExampleSentence;
	
}
