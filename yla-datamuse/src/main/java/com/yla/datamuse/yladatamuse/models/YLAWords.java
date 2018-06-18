package com.yla.datamuse.yladatamuse.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ylawords")
public class YLAWords {
	
	@Id
	String id;
	String wordName;
	String wordMeaning;
	String wordExample;
	public YLAWords(String id, String wordName, String wordMeaning, String wordExample) {
		super();
		this.id = id;
		this.wordName = wordName;
		this.wordMeaning = wordMeaning;
		this.wordExample = wordExample;
	}
	public YLAWords() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
