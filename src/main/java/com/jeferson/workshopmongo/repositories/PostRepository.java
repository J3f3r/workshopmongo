package com.jeferson.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jeferson.workshopmongo.models.entities.Post;


public interface PostRepository extends MongoRepository<Post, String> {

}
