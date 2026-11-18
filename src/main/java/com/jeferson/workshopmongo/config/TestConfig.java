package com.jeferson.workshopmongo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeferson.workshopmongo.models.entities.User;
import com.jeferson.workshopmongo.repositories.PostRepository;
import com.jeferson.workshopmongo.repositories.UserRepository;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TestConfig {

	private final UserRepository userRepository;

	private final PostRepository postRepository;

	
	TestConfig(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
		
	@PostConstruct
	public void init() {
		
		postRepository.deleteAll();
		userRepository.deleteAll();
		
		// faz o seed toda vez que inicializar
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
