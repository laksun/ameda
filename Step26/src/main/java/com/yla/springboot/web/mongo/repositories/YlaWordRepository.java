package com.yla.springboot.web.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yla.springboot.web.mongo.model.YLAWord;


@Repository
public interface YlaWordRepository extends MongoRepository<YLAWord, String> {
	
	

}
