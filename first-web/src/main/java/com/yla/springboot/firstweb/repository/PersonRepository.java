package com.yla.springboot.firstweb.repository;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import com.yla.springboot.firstweb.model.Person;

@Service
public class PersonRepository {
	
	@Autowired
	private LdapTemplate ldapTemplate;

	public Person findPerson(String userdn) {
		
		return ldapTemplate.lookup(userdn, new PersonAttributesMapper());
	}
	
	private class PersonAttributesMapper implements AttributesMapper<Person>{

		@Override
		public Person mapFromAttributes(Attributes attrs) throws NamingException {
			Person person = new Person();
			person.setFullName((String) attrs.get("cn").get());
			person.setLastName((String) attrs.get("sn").get());
			
			return person;
		}
		
	}
	
}



