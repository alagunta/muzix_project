package com.cgi.fav_muzix.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cgi.fav_muzix.model.MuzixFav;



public interface MuzixFavRepository extends MongoRepository<MuzixFav, String> {

}
