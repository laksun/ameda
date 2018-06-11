package com.yla.datamuse.yladatamuse;

import java.util.List;

public class Meaning {
	
	//[{"word":"deviance","score":81075,"tags":["syn","n"]},
	
	private String word;
	
	private int score;	
	
	private List<Tags> tags;
	
	

	
	public Meaning() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Meaning(String word, int score, List<Tags> tags) {
		super();
		this.word = word;
		this.score = score;
		this.tags = tags;
	}



	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Meaning [word=" + word + ", score=" + score + ", tags=" + tags + "]";
	}

	
}
