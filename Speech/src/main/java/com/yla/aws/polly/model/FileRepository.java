package com.yla.aws.polly.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yla.mongo.model.FileMongo;

public interface FileRepository extends MongoRepository<FileMongo, String> {

}
