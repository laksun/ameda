package com.yla.springboot.firstweb.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.yla.springboot.firstweb.controller.LoginController;
import com.yla.springboot.firstweb.model.Person;
import com.yla.springboot.firstweb.repository.PersonRepository;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class LdapLoginTest {

	@Test
	public void loginTest() {
		String userName = "yusuf";
		String password = "12345678";
		LoginController loginController = new LoginController();
		boolean passorfail = loginController.login(userName, password);
		assertEquals("The username password verification ", true, passorfail );
	}
	
	
	@Autowired
	private PersonRepository  personRepository;
	
	@Test
	public void testFindPerson() {
		String userDC = "uid=john,ou=people,dc=memorynotfound,dc=com";
		Person person = personRepository.findPerson(userDC);
		assertNotNull(person);
		assertEquals("John Doe", person.getFullName());
	}

}
