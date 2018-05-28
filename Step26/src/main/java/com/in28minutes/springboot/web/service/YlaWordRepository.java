package com.in28minutes.springboot.web.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.web.model.Ylaword;

@Repository
public interface YlaWordRepository extends CrudRepository<Ylaword, Integer> {

}
