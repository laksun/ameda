package com.yla.datamuse.yladatamuse.repositories;

import org.springframework.data.repository.CrudRepository;

import com.yla.datamuse.yladatamuse.models.YLAWords;

public interface YLAWordRepository extends CrudRepository<YLAWords, String> {
	
	@Override
	YLAWords   findOne(String id);
	
	@Override
	void   delete(YLAWords  deleted);
	
	

}
