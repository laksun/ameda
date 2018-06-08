package com.yla.springboot.web;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.yla.external.service.OwlWord;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFirstWebApplicationTests {

	@Autowired
	private RestTemplateBuilder restTemplate;

	// @Test
	public void contextLoads() {

		ResponseEntity responseEntity = restTemplate.build().getForEntity("https://owlbot.info/api/v2/dictionary/{id}",
				OwlWord.class, "ambition");
		responseEntity.getHeaders().entrySet().forEach((k) -> {
			System.out.println("Key is:" + k.getKey());
			System.out.println("Values are:" + k.getValue().stream().collect(Collectors.joining()));

		});

		System.out.println(responseEntity.getBody());
	}

	//@Test
	public void test2() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://owlbot.info/api/v2/dictionary/{id}";
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		HttpEntity<String> entity = new HttpEntity<String>("Hello World!", headers);
		ResponseEntity<OwlWord> wordEntity = restTemplate.exchange(uri, HttpMethod.GET, entity, OwlWord.class, "ambition");
		//System.out.println("ID:" + personEntity.getBody().getId());
		System.out.println("Name:" + wordEntity.getBody().getName());
		System.out.println("Village:" + wordEntity.getBody().getDescription());
	}
	


	
	

}


