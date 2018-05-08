package com.yla.springboot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yla.springboot.web.model.Todo;

@Repository
public interface TodoRepository  extends JpaRepository<Todo, Integer>{
	List<Todo> findByUser(String user);

}
