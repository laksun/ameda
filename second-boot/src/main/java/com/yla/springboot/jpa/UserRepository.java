package com.yla.springboot.jpa;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	//public List<User> findByRole(String role);
}