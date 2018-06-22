package com.yla.jwi;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.Pointer;

public class TestDictionary {

	@Test
	public void testDictionary() {

		System.setProperty("WNHOME", "D:\\Development\\WSAmeda\\data");

		String wnhome = System.getProperty("WNHOME");
		String path = wnhome + File.separator + "dict";
		URL url = null;
		try {
			url = new URL("file", null, path);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// construct the dictionary object and open it
		IDictionary dict = new Dictionary(url);
		try {
			dict.open();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// look up first sense of the word "dog "
		//IIndexWord idxWord = dict.getIndexWord("appease", POS.VERB);
		 IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
		 
		 

		IWordID wordID = idxWord.getWordIDs().get(0);
		IWord word = dict.getWord(wordID);
		System.out.println("Id = " + wordID);
		System.out.println(" Lemma = " + word.getLemma());
		System.out.println(" Gloss = " + word.getSynset().getGloss());

		// synonyms
		ISynset synonmySet = word.getSynset();

		for (IWord w : synonmySet.getWords()) {
			System.out.println(w.getLemma());
		}

		// hypernyms

		// get the hypernyms
		List<ISynsetID> hypernyms = synonmySet.getRelatedSynsets(Pointer.HYPERNYM);

		// print out each h y p e r n y m s id and synonyms
		List<IWord> words;
		for (ISynsetID sid : hypernyms) {
			words = dict.getSynset(sid).getWords();
			System.out.print(sid + " {");

			for (Iterator<IWord> i = words.iterator(); i.hasNext();) {
				System.out.print(i.next().getLemma());
				if (i.hasNext())
					System.out.print(", ");
			}
			System.out.println("}");

		}
		assertEquals("", wordID.toString());
	}

}
