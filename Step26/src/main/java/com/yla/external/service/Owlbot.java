package com.yla.external.service;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Owlbot {

	public static void main(String[] args) {
		// https://owlbot.info/api/v2/dictionary/ambition

		// read a list of words

		// call the rest for each word

		// write the words into db

		Owlbot owl = new Owlbot();
		owl.anothertry4();

		
	}

	public void anothertry() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		Object response = restTemplate.exchange("https://owlbot.info/api/v2/dictionary/ambition", HttpMethod.GET,	entity, Object.class).getBody();
		// ResponseEntity<OwlWord> response =		 restTemplate.getForEntity("https://owlbot.info/api/v2/dictionary/ambition",OwlWord.class,entity);
		System.out.println(response);
	}

	public void anothertry2() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		Object result = restTemplate.getForObject("https://owlbot.info/api/v2/dictionary/ambition",				Object.class);
		//List<OwlWord> result = restTemplate.getForObject("https://owlbot.info/api/v2/dictionary/ambition",List<OwlWord>.class);
		System.out.println(result);
	}
	
	public void anothertry3() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		//Object result = restTemplate.getForObject("https://owlbot.info/api/v2/dictionary/ambition",				Object.class);
		
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("https://owlbot.info/api/v2/dictionary/ambition", Object[].class);
		Object objects = responseEntity.getBody();
		System.out.println(objects.toString());
	}
	
	public void anothertry4() {
		CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier())
				.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setHttpClient(httpClient);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		//HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		
//		ResponseEntity<List<OwlWord>> rateResponse =
//		        restTemplate.exchange("https://owlbot.info/api/v2/dictionary/ambition",
//		                    HttpMethod.GET, entity, new ParameterizedTypeReference <List<OwlWord>>() {
//		            });
//		List<OwlWord> rates = rateResponse.getBody();
		
		Object[] forNow = restTemplate.getForObject("https://owlbot.info/api/v2/dictionary/ambition", Object[].class);
	    List searchList= Arrays.asList(forNow);
		System.out.println(searchList.toString());
		
		JsonReader reader = new JsonReader(new StringReader(searchList.toString()));
		reader.setLenient(true);
		
		Gson gson = new Gson();  
		OwlWord[] founderArray = gson.fromJson(reader, OwlWord[].class);
		
		System.out.println(founderArray.toString());
	}

}
















