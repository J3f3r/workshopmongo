package com.jeferson.workshopmongo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jeferson.workshopmongo.models.dto.UserDTO;
import com.jeferson.workshopmongo.models.entities.User;
import com.jeferson.workshopmongo.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserDTO> findAll(){
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
}
