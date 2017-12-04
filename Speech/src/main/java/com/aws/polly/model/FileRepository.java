package com.aws.polly.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileMongo, String> {

}
