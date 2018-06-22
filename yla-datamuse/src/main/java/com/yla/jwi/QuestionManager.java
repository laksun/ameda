package com.yla.jwi;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;

//read the list
// for each word
// get the definition
// get the synonyms
// get the hypernyms
//insert into mongodb

public class QuestionManager {

	String error = "";

	public static void main(String[] args) {
		// read the list
		QuestionManager qm = new QuestionManager();

		String fileName = "D:\\Development\\WSAmeda\\data\\wordlist\\wordlist1.txt";
		// for each line create a question

		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			// stream.forEach(System.out::println);
			stream.forEach(word -> qm.createQuestion(word));

		}

		catch (Exception e) {
			qm.error = e.toString();
			e.printStackTrace();
		}

	}

	// input is a word, for this word create a question
	// get the synonyms and meaning
	// get the choice words
	// insert into mongodb
	// Question
	private  Object createQuestion(String word) {
		// TODO Auto-generated method stub
		Question q = new Question();
		
		//for each word there may be more than one pos and also more than one meaning and, more than one set of synonyms
		
		List<Question> wordList = getWordsPos(word);
		
		q.setWord(word);
		// get the meaning from the dictionary 
		

		return null;
	}
	
	// check the pos of the word there may be more than one meaning for a word
	
	private List<Question> getWordsPos(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	//input a word,  output a list of words with POS
	private Set<String>  getWords(String searchword){
		Set<String> lexicon = new HashSet<>();

		for (POS p : POS.values()) {
		    IIndexWord idxWord = dict.getIndexWord(searchword, p);
		    if (idxWord != null) {
		        System.out.println("\t : " + idxWord.getWordIDs().size());
		        IWordID wordID = idxWord.getWordIDs().get(0);
		        IWord word = dict.getWord(wordID);
		        ISynset synset = word.getSynset();
		        System.out.print(synset.getWords().size());
		        for (IWord w : synset.getWords()) {
		            lexicon.add(w.getLemma());
		        }

		    }
		}

		for (String s : lexicon) {
		    System.out.println("wordnet lexicon : " + s);
		}
		
		return lexicon;
	}

	
	
	
	
	
	static String wnhome;
	static String path;
	static IDictionary dict;
	static {
		System.setProperty("WNHOME", "D:\\Development\\WSAmeda\\data");

		wnhome = System.getProperty("WNHOME");
		path = wnhome + File.separator + "dict";

		URL url = null;
		try {
			url = new URL("file", null, path);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// construct the dictionary object and open it
		dict = new Dictionary(url);
		try {
			dict.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int readFile(String fileName) {
		// TODO Auto-generated method stub
		// returns the number of lines
		int x = 5;

		try {
			Stream<String> stream = Files.lines(Paths.get(fileName));
			// stream.forEach(System.out::println);
			stream.forEach(line -> printLine(line));

			x = 1;

		}

		catch (Exception e) {
			error = e.toString();
			e.printStackTrace();
		}
		return x;

	}

	private void printLine(String line) {
		System.out.println(line);
	}

	public String getWordMeaning(String lookupword) {
		// TODO Auto-generated method stub

		// look up first sense of the word "dog "
		// IIndexWord idxWord = dict.getIndexWord("appease", POS.VERB);
		IIndexWord idxWord = dict.getIndexWord(lookupword, POS.NOUN);

		IWordID wordID = idxWord.getWordIDs().get(0);
		IWord word = dict.getWord(wordID);
		System.out.println("Id = " + wordID);
		System.out.println(" Lemma = " + word.getLemma());
		System.out.println(" Gloss = " + word.getSynset().getGloss());
		return word.getSynset().getGloss();
	}

}
