package com.yla.datamuse.yladatamuse;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;



public class DatamuseWords {

	public static void main(String[] args) {
		getWords();

	}
	
	
	//array of words returned
	private static void getWords() {
		
		final String uri = "https://api.datamuse.com/words?ml=aberration";
		
		RestTemplate restTemplate = new RestTemplate();
		
		//String result = restTemplate.getForObject(uri, String.class);//, uriVariables);		
		
		//System.out.println(result);
		
		// for each word in text call the JSONParse and insert the meanings into the mongo db
		
		String fileName = "c://Users//admin//Documents//wordList.txt";
		
		try ( Stream<String> stream = Files.lines(Paths.get(fileName))){
			stream.forEach(arg0 -> {
				try {
					JSONParse(arg0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*try {
			JSONParse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	
	public static void JSONParse (String word) throws JsonParseException, JsonMappingException	, IOException {

	 
	        /* JSON provider */
	        URL url = new URL("https://api.datamuse.com/words?ml="+word);

	        ObjectMapper mapper = new ObjectMapper();

	        /*
	         * This allows the ObjectMapper to accept single values for a collection.
	         * For example: "location" property in the returned JSON is a collection that 
	         * can accept multiple objects but, in deserialization process, this property just 
	         * have one object and causes an Exception.
	         */
	        mapper.configure(Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

	        /* 
	         * If some JSON property is not present, avoid exceptions setting
	         * FAIL_ON_UNKNOWN_PROPERTIES to false 
	         */
	        mapper.configure( Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	        /* Get all meanings */
	        List<Meaning> meanings = mapper.readValue(url, new TypeReference<List<Meaning>>(){});

	        //create the word class
	        //and insert into db
	        Dictword dictword = new Dictword();
	        dictword.setMeanings(meanings);
	        dictword.setWordName(word);
	        
	        //call the insert service
	        
	        /* Print each meaning (previously overriding "toString()" method) */
	        for(Meaning meaning : meanings) {
	            System.out.println(meaning.toString());
	        }	    

	}
	
	private static void insertDictWord(Dictword dictWord) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Dictword> word = new HttpEntity<Dictword>(dictWord,headers);
		
		//send the request to insert into the mongo db
		ResponseEntity<String>  out = restTemplate.exchange("url", HttpMethod.POST, word, String.class);
		
		
	}
	
	
	
	

}
