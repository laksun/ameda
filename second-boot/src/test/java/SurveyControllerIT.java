import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import com.yla.springboot.Application;
import com.yla.survey.model.Question;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {
	
	@LocalServerPort
	private int port;

	@Test
	public void test() {
		System.out.println("PORT is "+port);
		
		String url = "http://localhost:" + port
				+ "/surveys/Survey1/questions/Question1";
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String>  entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String>  response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		
		String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
		JSONAssert.assertEquals(expected,response.getBody(), false);
	}
	
	@Test
	public void retrieveAllSurveyQuestions() throws Exception{
		String url = "http://localhost:" + port + "/surveys/Survey1/questions";

		
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		ResponseEntity<List<Question>>  response = restTemplate.exchange(url,  HttpMethod.GET, new HttpEntity<String> ("DUMMY_DOESNT_MATTER",headers), new ParameterizedTypeReference<List<Question>>() {
		});
		Question sampleQuestion = new Question("Question1",
				"Largest Country in the World", "Russia", Arrays.asList(
						"India", "Russia", "United States", "China"));
		assertTrue(response.getBody().contains(sampleQuestion));
		
				
				
		
		
	}
	

}
