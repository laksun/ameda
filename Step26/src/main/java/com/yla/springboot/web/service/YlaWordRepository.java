package com.yla.springboot.web.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yla.springboot.web.model.Ylaword;

@Repository
public interface YlaWordRepository extends CrudRepository<Ylaword, Integer> {

}
