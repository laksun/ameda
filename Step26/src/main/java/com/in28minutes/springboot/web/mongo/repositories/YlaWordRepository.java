package com.in28minutes.springboot.web.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.web.mongo.model.YLAWord;


@Repository
public interface YlaWordRepository extends MongoRepository<YLAWord, String> {
	
	

}
