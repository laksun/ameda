package com.yla.jwi;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;



public class QFileReader {
	
	String error= "";
	
	
	
	static String wnhome;
	static String path;
	static IDictionary dict;
	static{
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
		//returns the number of lines
		int x =5;
		
		try {			
			Stream<String>   stream = Files.lines(Paths.get(fileName));
			//stream.forEach(System.out::println);
			stream.forEach (line -> printLine(line));
			x=1;

		}
		
		catch (Exception e) {
			error = e.toString();
			e.printStackTrace();
		}
		return x;
	
	}
	
	private void  printLine(String  line) {
		System.out.println(line);
	}

	public String getWordMeaning(String lookupword ) {
		// TODO Auto-generated method stub
		
		// look up first sense of the word "dog "
		//IIndexWord idxWord = dict.getIndexWord("appease", POS.VERB);
		 IIndexWord idxWord = dict.getIndexWord(lookupword, POS.NOUN);

		IWordID wordID = idxWord.getWordIDs().get(0);
		IWord word = dict.getWord(wordID);
		System.out.println("Id = " + wordID);
		System.out.println(" Lemma = " + word.getLemma());
		System.out.println(" Gloss = " + word.getSynset().getGloss());
		return word.getSynset().getGloss();
	}

}
