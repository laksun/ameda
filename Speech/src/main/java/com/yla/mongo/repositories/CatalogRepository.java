package com.yla.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yla.mongo.model.Catalog;

public interface CatalogRepository extends MongoRepository<Catalog, String> {

}
