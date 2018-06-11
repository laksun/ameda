package com.yla.datamuse.yladatamuse;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Dictword {
	
	private String wordName;
	private List<Meaning> meanings;
	public Dictword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dictword(String wordName, List<Meaning> meanings) {
		super();
		this.wordName = wordName;
		this.meanings = meanings;
	}
	public String getWordName() {
		return wordName;
	}
	public void setWordName(String wordName) {
		this.wordName = wordName;
	}
	public List<Meaning> getMeanings() {
		return meanings;
	}
	public void setMeanings(List<Meaning> meanings) {
		this.meanings = meanings;
	}
	@Override
	public String toString() {
		return "Dictword [wordName=" + wordName + ", meanings=" + meanings + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meanings == null) ? 0 : meanings.hashCode());
		result = prime * result + ((wordName == null) ? 0 : wordName.hashCode());
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
		Dictword other = (Dictword) obj;
		if (meanings == null) {
			if (other.meanings != null)
				return false;
		} else if (!meanings.equals(other.meanings))
			return false;
		if (wordName == null) {
			if (other.wordName != null)
				return false;
		} else if (!wordName.equals(other.wordName))
			return false;
		return true;
	}
	
	

}
