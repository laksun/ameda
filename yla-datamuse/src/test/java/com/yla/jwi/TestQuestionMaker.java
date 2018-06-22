package com.yla.jwi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestQuestionMaker {
	// read the list
	// for each word
	// get the definition
	// get the synonyms
	// get the hypernyms
	//insert into mongodb
	
	
	@Test
	public void testReadListFile() {
		String fileName = "D:\\Development\\WSAmeda\\data\\wordlist\\wordlist1.txt";
		
		QuestionManager qFileReader = new QuestionManager();
		int numberOfLines = qFileReader.readFile(fileName);
		System.out.println(qFileReader.error);
		
		assertEquals(0, numberOfLines);
		
	}
	
	@Test
	public void testWordMeaning() {
		
		String word= "";
		QuestionManager qFileReader = new QuestionManager();
		String meaning = qFileReader.getWordMeaning("");
		assertEquals("", meaning);
		
		
	}

}
