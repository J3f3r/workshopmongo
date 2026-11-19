package com.jeferson.workshopmongo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeferson.workshopmongo.models.dto.UserDTO;
import com.jeferson.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<UserDTO> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		UserDTO obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
