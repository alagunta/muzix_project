package com.cgi.recom_muzix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cgi.recom_muzix.model.Recommended;



public interface RecommendedRepository extends MongoRepository<Recommended, String> {

}
