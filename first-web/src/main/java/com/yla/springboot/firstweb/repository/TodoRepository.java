package com.yla.springboot.firstweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yla.springboot.firstweb.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>  {
	
	List<Todo>  findByUser(String user);

}
