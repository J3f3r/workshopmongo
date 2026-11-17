package com.jeferson.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.jeferson.workshopmongo.models.entities.User;


public interface UserRepository extends MongoRepository<User, String> {

}
