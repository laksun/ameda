package com.yla.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yla.mongo.model.FileMongo;

public interface FileMongoRepository extends MongoRepository<FileMongo, String> {

}
